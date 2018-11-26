package pers.nasanir.funny.nospider.web;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Spider {
    private String target;

    private WebClient webClient;
    private HtmlPage page;


    public Spider(String target, BrowserVersion browserVersion) {
        this.target = target;
        this.webClient = new WebClient(browserVersion);
        init();
    }

    public Spider(String target) {
        this.target = target;
        this.webClient = new WebClient(BrowserVersion.CHROME);
        init();
    }

    private void init() {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);
//        ProxyConfig proxyConfig=new ProxyConfig();
//        proxyConfig.setProxyHost("192.168.6.22");
//        proxyConfig.setProxyPort(3128);
//        webClient.getOptions().setProxyConfig(proxyConfig);
    }

    public HtmlPage find() throws IOException {
        page = webClient.getPage(target);
//        webClient.waitForBackgroundJavaScript(30 * 1000);
//        String pageAsXml = page.asXml();
        return page;
    }

    public WebClient getWebClient() {
        return webClient;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
