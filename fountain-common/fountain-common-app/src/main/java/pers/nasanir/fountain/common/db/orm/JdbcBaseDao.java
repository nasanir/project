package pers.nasanir.fountain.common.db.orm;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.db.impl.CrudDao;

import java.util.HashMap;
import java.util.List;

/**
 * 通用查询dao层
 * 
 * @author nasanir
 *
 */
@Repository("jdbcBaseDao")
public class JdbcBaseDao {
	@Autowired
	private CrudDao crudDao;

	public List<HashMap<String, Object>> query(QueryVO vo,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo,pageSize);
		List<HashMap<String, Object>> valueList = crudDao.query(vo);
		return valueList;
	}

    public void add(DataVO vo){
        // TODO Auto-generated method stub
        crudDao.add(vo);
    }

	private List<AbstractVO> transFormData(List<HashMap<String, Object>> valueList) {
		return null;
	}

}
