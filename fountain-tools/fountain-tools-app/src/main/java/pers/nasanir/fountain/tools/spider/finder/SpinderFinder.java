package pers.nasanir.fountain.tools.spider.finder;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import pers.nasanir.fountain.tools.spider.finder.enumerate.BrowserVersionEnum;

import java.io.IOException;


public class SpinderFinder {
    public HtmlPage startFind(String target, BrowserVersion browserVersion) throws IOException {
        WebClient webClient=new WebClient(browserVersion);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(3*1000);
        return webClient.getPage(target);
    }

    public HtmlPage startFind(String target) throws IOException {
        return startFind(target,BrowserVersion.CHROME);
    }
}
