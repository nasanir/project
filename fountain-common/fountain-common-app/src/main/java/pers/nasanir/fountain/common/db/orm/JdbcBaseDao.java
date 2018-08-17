package pers.nasanir.fountain.common.db.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.impl.CrudDao;
import pers.nasanir.fountain.common.function.mapper.FuncVOMapper;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.reflect.Invoker;
import pers.nasanir.fountain.common.sql.constant.DbConstant;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * 通用查询dao层
 *
 * @author nasanir
 */
@Repository("jdbcBaseDao")
public class JdbcBaseDao {
    @Autowired
    private CrudDao crudDao;
    @Autowired
    private FuncVOMapper funcVOMapper;

    public VOSet query(QueryVO vo) {
        // TODO Auto-generated method stub
        List<HashMap<String, Object>> valueList = crudDao.query(vo);
        return transFormData(valueList,vo);
    }

    public void add(DataVO vo) {
        // TODO Auto-generated method stub
        crudDao.add(vo);
    }

    private <T extends AbstractVO> VOSet transFormData(List<HashMap<String, Object>> valueList, QueryVO vo){
        VOSet<AbstractVO> voSet=new VOSet<AbstractVO>();

        Class clz= null;
        try {
            clz = Class.forName(funcVOMapper.selectByCode(vo.getFuncCode()).getFunctionEntity());
            ClassInfo classInfo=ClassInfo.forClass(clz);
            HashMap<String,Invoker> invokerHashMap=classInfo.getInvokerMap();

            for(HashMap<String, Object> valueMap:valueList){
                T obj=(T)clz.newInstance();
                for(String field:valueMap.keySet()){
                    String invokerName=CommonConstant.SET+field.replace(DbConstant.SIGN_UNDERLINE,"").toLowerCase(Locale.ROOT);
                    Invoker invoker=invokerHashMap.get(invokerName);
                    Object[] objArr={valueMap.get(field)};
                    invoker.invoke(obj,objArr);
                }
                voSet.addVo(obj);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return voSet;
    }

}
