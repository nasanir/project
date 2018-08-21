package pers.nasanir.fountain.common.function.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.ParamterVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.function.itf.IFunctionService;

import java.util.HashMap;
import java.util.List;
@Service("functionService")
public class FunctionServiceImpl implements IFunctionService {
    @Override
    public VOSet showList(ParamterVO vo) {
        return null;
    }
//    @Autowired
//    IJdbcBaseService jdbcBaseService;
//
//    public VOSet showList(ParamterVO vo){
//        QueryVO queryVO=new QueryVO();
//        queryVO.setFuncCode(vo.getFuncCode());
//        queryVO.setModule(vo.getModule());
//        queryVO.createPageInfo(vo.getLimit(),vo.getPageNo());
//        VOSet resultSet= jdbcBaseService.query(queryVO);
//        return resultSet;
//    }
}
