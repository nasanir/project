package pers.nasanir.foutain.manager.function.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.foutain.manager.function.itf.IFuncService;

@RestController
public class FunctionController {
    @Autowired
    IFuncService funcService;

    @RequestMapping(value = "/{module}/{function}/add",method = RequestMethod.PUT)
    public AbstractVO FunctionAdd(@PathVariable String module, @PathVariable String function){
        DataVO vo=(DataVO)funcService.add(module,function);
        return vo;
    }
}
