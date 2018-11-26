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
import java.util.List;

public class LotsOfLogin{
    private static Logger LOGGER = LogManager.getLogger(LotsOfLogin.class);
    private String url;
    public LotsOfLogin(String url){
        this.url=url;
    }


    public void start(List<FakeUserMd> userMdList) throws IOException {
        for(FakeUserMd userMd:userMdList){
            Spider spider=new Spider(url);
            FakeLoginMd fakeLoginMd=new FakeLoginMd();
            fakeLoginMd.setFormName("loginform");
            fakeLoginMd.setUsernameText("username");
            fakeLoginMd.setPasswordText("password");
            fakeLoginMd.setLoginBtnId("loginbutton");
            fakeLoginMd.setLoginFlagId("mx41");
            HtmlPage page=spider.find();
            LoginThread loginThread=new LoginThread(page,fakeLoginMd,userMd,spider.getWebClient());
            Thread thread=new Thread(loginThread);
            thread.start();
        }
    }
}
