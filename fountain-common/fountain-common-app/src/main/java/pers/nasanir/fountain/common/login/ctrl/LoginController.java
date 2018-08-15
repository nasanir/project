package pers.nasanir.fountain.common.login.ctrl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.crypto.constant.EncoderEnum;
import pers.nasanir.fountain.common.crypto.factory.CryptoFactory;
import pers.nasanir.fountain.common.crypto.itf.IEncoder;
import pers.nasanir.fountain.common.db.service.JdbcBaseServiceImpl;

@Controller
public class LoginController {
    @Autowired
    JdbcBaseServiceImpl jdbcBaseService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUrl(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        boolean isremanber = SecurityUtils.getSubject().isRemembered();
//        boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
//        if (isAuthenticated || isremanber) {
//            return "index";
//        }
//        QueryVO vo=new QueryVO();
//        vo.setFuncCode("FUNC");

//        DataVO dataVO=new DataVO();
//        dataVO.setAction("add");
//        dataVO.setFunction("FUNC");
//        dataVO.setModule("COMMON");
//        VOSet<FuncVO> voSet=new VOSet<FuncVO>();
//        FuncVO funcVO=new FuncVO();
//        funcVO.setFunctionId(5L);
//        funcVO.setTableName("FOUNTAIN_MANAGER_FIELD");
//        funcVO.setFunctionCode("FIELD");
//        funcVO.setFunctionName("字段");
//        funcVO.setIsvaild(true);
//        funcVO.setCreatedDt(new Date());
//        funcVO.setCreatedBy("admin");
//        funcVO.setChangeDt(new Date());
//        funcVO.setChangeBy("admin");
//        voSet.addVo(funcVO);
//        dataVO.setDataSet(voSet);
//        jdbcBaseService.add(dataVO);
       return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IEncoder hex256Encoder = CryptoFactory.getInstance(EncoderEnum.HEX256);
        UsernamePasswordToken token;
        try {
            token = new UsernamePasswordToken(request.getParameter("username"),
                    hex256Encoder.encode2Hex(request.getParameter("password")));
            SecurityUtils.getSubject().login(token);
            return "index";
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/blog/a")
    public String a() {
        return "a";
    }
}
