package pers.nasanir.funny.nospider.model;

public class FakeLoginMd {
    private String formName;


    private String usernameText;

    private String passwordText;

    private String loginBtnId;

    private String loginFlagId;

    public String getLoginFlagId() {
        return loginFlagId;
    }

    public void setLoginFlagId(String loginFlagId) {
        this.loginFlagId = loginFlagId;
    }

    public String getLoginBtnId() {
        return loginBtnId;
    }

    public void setLoginBtnId(String loginBtnId) {
        this.loginBtnId = loginBtnId;
    }

    public String getUsernameText() {
        return usernameText;
    }

    public void setUsernameText(String usernameText) {
        this.usernameText = usernameText;
    }

    public String getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

}
