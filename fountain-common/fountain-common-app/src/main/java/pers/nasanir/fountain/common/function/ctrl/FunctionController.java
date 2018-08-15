package pers.nasanir.fountain.common.function.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.ResultVO;
import pers.nasanir.fountain.common.db.service.JdbcBaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Controller
public class FunctionController {
    @Autowired
    JdbcBaseServiceImpl jdbcBaseService;

    @RequestMapping(value = "/{module}/{function}/showList",method = RequestMethod.POST)
    public List<HashMap<String,Object>> showList(HttpServletRequest request, @PathVariable String module, @PathVariable String function){
        QueryVO vo=new QueryVO();
        vo.setFuncCode("FUNC");
        return jdbcBaseService.query(vo,2,2);
    }


}
