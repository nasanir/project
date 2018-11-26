package pers.nasanir.fountain.tools.spider.finder.enumerate;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public enum BrowserVersionEnum {
    CHROME(BrowserVersion.CHROME);
    BrowserVersion browerVersion;

    BrowserVersionEnum(BrowserVersion browserVersion){
        this.browerVersion=browserVersion;
    }
}
