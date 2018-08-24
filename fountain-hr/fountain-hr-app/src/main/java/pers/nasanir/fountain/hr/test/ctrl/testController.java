package pers.nasanir.fountain.hr.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
    @RequestMapping(value = "/hr/test",method = RequestMethod.GET)
    public String test(){
        return "list";
    }
    @RequestMapping(value = "/hr/test2",method = RequestMethod.GET)
    public String test2(){
        return "login.html";
    }
}
