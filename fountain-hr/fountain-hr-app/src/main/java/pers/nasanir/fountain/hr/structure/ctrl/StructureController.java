package pers.nasanir.fountain.hr.structure.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;
import pers.nasanir.fountain.hr.structure.itf.IStructureService;
import pers.nasanir.fountain.hr.structure.service.StructureServiceImpl;
import pers.nasanir.foutain.manager.dbmanger.itf.DbMangerService;

import java.io.IOException;
import java.util.List;
@RestController
public class StructureController {

    @Autowired
    IStructureService structureService;

    @RequestMapping(value = "/hr/structure/getdata",method = RequestMethod.GET)
    public List<StructureVO> getData() throws IOException {
        return structureService.getData();
    }
}
