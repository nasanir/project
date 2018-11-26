package pers.nasanir.funny.nospider.tools.lotofLogin;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pers.nasanir.funny.nospider.action.FakeLogin;
import pers.nasanir.funny.nospider.model.FakeLoginMd;
import pers.nasanir.funny.nospider.model.FakeUserMd;
import pers.nasanir.funny.nospider.web.Spider;

import java.io.IOException;

public class LoginThread implements Runnable  {
    private static Logger LOGGER = LogManager.getLogger(LoginThread.class);

    private HtmlPage page;
    private FakeLoginMd loginMd;
    private FakeUserMd userMd;
    private WebClient webClient;

    public LoginThread(HtmlPage page, FakeLoginMd loginMd, FakeUserMd userMd,WebClient webClient){
        this.page=page;
        this.loginMd=loginMd;
        this.userMd=userMd;
        this.webClient=webClient;
    }

    public void run() {
        try {
            FakeLogin fakeLogin=new FakeLogin(page,loginMd,userMd,webClient);
            boolean flag=fakeLogin.login();
            if(flag){
                LOGGER.info("username:"+userMd.getUsername()+"  true");
            }else{
                LOGGER.info("username:"+userMd.getUsername()+"  false");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
