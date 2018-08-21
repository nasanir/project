package pers.nasanir.fountain.common.function.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.nasanir.fountain.common.common.entity.ParamterVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.function.itf.IFunctionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class FunctionController {
//FunctionController    @Autowired
//    IFunctionService functionService;
//
//    @RequestMapping(value = "/{module}/{function}/showList",method = RequestMethod.POST)
//    public VOSet showList(HttpServletRequest request, @PathVariable String module, @PathVariable String function, int pageNo, int limit){
//        ParamterVO paramterVO=new ParamterVO();
//        paramterVO.setFuncCode(function);
//        paramterVO.setModule(module);
//        paramterVO.setRequest(request);
//        paramterVO.setPageNo(pageNo);
//        paramterVO.setLimit(limit);
//        return functionService.showList(paramterVO);
//    }
//
//
//    @RequestMapping(value = "/{module}/{function}/add",method = RequestMethod.POST)
//    public VOSet add(HttpServletRequest request, @PathVariable String module, @PathVariable String function, int pageNo, int limit){
//        ParamterVO paramterVO=new ParamterVO();
//        paramterVO.setFuncCode(function);
//        paramterVO.setModule(module);
//        paramterVO.setRequest(request);
//        paramterVO.setPageNo(pageNo);
//        paramterVO.setLimit(limit);
//        return functionService.showList(paramterVO);
//    }



}
