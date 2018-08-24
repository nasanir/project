package pers.nasanir.fountain.hr.structure.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.nasanir.fountain.common.common.entity.ParamterVO;
import pers.nasanir.fountain.common.common.entity.ResultVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;
import pers.nasanir.fountain.hr.structure.itf.IStructureService;
import pers.nasanir.fountain.hr.structure.mapper.StructureVOMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@RestController
public class StructureController {
    @Autowired
    StructureVOMapper structureVOMapper;
    @Autowired
    IStructureService structureService;

    @RequestMapping(value = "/{module}/structure/showList",method = RequestMethod.POST)
    public ResultVO showList(HttpServletRequest request, @PathVariable String module,@RequestBody String requestBody){
        ParamterVO paramterVO=new ParamterVO();
        paramterVO.setFuncCode("structure");
        paramterVO.setModule(module);
        paramterVO.setRequest(request);
        paramterVO.setDataBody(requestBody);
        return structureService.showList(paramterVO);
    }


    @RequestMapping(value = "/{module}/structure/add",method = RequestMethod.POST)
    public ResultVO add(HttpServletRequest request, @PathVariable String module, int pageNo, int limit){
        ParamterVO paramterVO=new ParamterVO();
        paramterVO.setFuncCode("structure");
        paramterVO.setModule(module);
        paramterVO.setRequest(request);
        paramterVO.setPageNo(pageNo);
        paramterVO.setLimit(limit);
        return structureService.add(paramterVO);
    }

    @RequestMapping(value = "/{module}/structure/save",method = RequestMethod.POST)
    public ResultVO save(HttpServletRequest request, @PathVariable String module, @RequestBody String requestBody, int pageNo, int limit){
        ParamterVO paramterVO=new ParamterVO();
        paramterVO.setFuncCode("structure");
        paramterVO.setModule(module);
        paramterVO.setRequest(request);
        paramterVO.setPageNo(pageNo);
        paramterVO.setLimit(limit);
        paramterVO.setDataBody(requestBody);
        return structureService.save(paramterVO);
    }



}
