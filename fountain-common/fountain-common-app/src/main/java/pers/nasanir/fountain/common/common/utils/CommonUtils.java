package pers.nasanir.fountain.common.common.utils;

import pers.nasanir.fountain.common.common.entity.ParamterVO;
import pers.nasanir.fountain.common.common.entity.ResultVO;

public class CommonUtils {
    public static void transParamToResult(ParamterVO paramterVO, ResultVO resultVO){
        resultVO.setModule(paramterVO.getModule());
        resultVO.setFuncCode(paramterVO.getFuncCode());
        resultVO.setPageNo(paramterVO.getPageNo());
        resultVO.setLimit(paramterVO.getLimit());
    }
}
