package per.nasanir.nospider.web;

import org.apache.commons.httpclient.HttpClient;

public class SpiderFoots {

    private String target;

    private HttpClient httpClient=null;


    SpiderFoots(){
        this.httpClient=new HttpClient();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
