package pers.nasanir.foutain.manager.function.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.foutain.manager.function.entity.FuncVO;
import pers.nasanir.foutain.manager.function.itf.IFuncService;

import java.util.ArrayList;
import java.util.List;

@Service("funcService")
public class FuncServiceImpl implements IFuncService {

    @Autowired
    IJdbcBaseService jdbcBaseService;

    @Override
    public AbstractVO add(String module, String function) {
        ArrayList<AbstractVO> voList=new ArrayList<AbstractVO>();

        VOSet voSet=new VOSet();

        FuncVO funcVo=new FuncVO();
        funcVo.setFunc_code(function);
        funcVo= (FuncVO) jdbcBaseService.query(funcVo);
        voList.add(funcVo);

        voSet.setVoList(voList);

        DataVO dataVo=new DataVO();
        dataVo.setAction("ADD");
        dataVo.setModule(module);
        dataVo.setFunction(function);
        dataVo.setDataSet(voSet);

        return dataVo;
    }

    @Override
    public AbstractVO save(String module, String function, AbstractVO vo) {
        return null;
    }

    @Override
    public AbstractVO edit(String module, String function) {
        return null;
    }

    @Override
    public AbstractVO delete(String module, String function, AbstractVO vo) {
        return null;
    }

    @Override
    public List<AbstractVO> showList(String module, String function, AbstractVO vo) {
        return null;
    }

    @Override
    public AbstractVO show(String module, String function, AbstractVO vo) {
        return null;
    }
}
