package pers.nasanir.fountain.tools.spider.finder.entity;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import pers.nasanir.fountain.tools.spider.crypto.constant.EncoderEnum;
import pers.nasanir.fountain.tools.spider.crypto.factory.CryptoFactory;

import java.security.NoSuchAlgorithmException;

public class SpiderVO {
    private String url;
    private String frontUrl;

    private String frontUuid;
    private String uuid;

    private HtmlPage page;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        try {
            if(this.frontUrl!=null){
                this.uuid=CryptoFactory.getInstance(EncoderEnum.HEX256).encode2Hex(this.frontUrl+url);
            }else{
                this.uuid=CryptoFactory.getInstance(EncoderEnum.HEX256).encode2Hex(url);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.url = url;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public String getFrontUuid() {
        return frontUuid;
    }

    public void setFrontUuid(String frontUuid) {
        this.frontUuid = frontUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public HtmlPage getPage() {
        return page;
    }

    public void setPage(HtmlPage page) {
        this.page = page;
    }
}
