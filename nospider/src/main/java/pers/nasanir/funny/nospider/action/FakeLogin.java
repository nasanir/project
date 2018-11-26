package pers.nasanir.funny.nospider.action;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import pers.nasanir.funny.nospider.model.FakeLoginMd;
import pers.nasanir.funny.nospider.model.FakeUserMd;

import java.io.IOException;

public class FakeLogin {
   private HtmlForm loginForm;
   private HtmlTextInput usernameInput;
   private HtmlPasswordInput passwordInput;
   private HtmlButton loginBtn;
   private boolean isLogin;
    private WebClient webClient;

    private HtmlPage page;
    private  FakeLoginMd loginMd;
    private FakeUserMd userMd;


    public FakeLogin(HtmlPage page, FakeLoginMd loginMd, FakeUserMd userMd,WebClient webClient){
        this.page=page;
        this.loginMd=loginMd;
        this.userMd=userMd;
        this.webClient=webClient;

        isLogin=false;

        loginForm=page.getFormByName(loginMd.getFormName());

        usernameInput=loginForm.getInputByName(loginMd.getUsernameText());
        passwordInput=loginForm.getInputByName(loginMd.getPasswordText());
        usernameInput.setValueAttribute(userMd.getUsername());
        passwordInput.setValueAttribute(userMd.getPassword());

        loginBtn=page.getHtmlElementById(loginMd.getLoginBtnId());
    }

    public boolean login() throws IOException {
        HtmlPage returnPage=loginBtn.click();
        webClient.waitForBackgroundJavaScript(10000);
        if(returnPage.getElementById(loginMd.getLoginFlagId())!=null){
            isLogin=true;
        }else{
            isLogin=false;
        }
        return isLogin;
    }
}
