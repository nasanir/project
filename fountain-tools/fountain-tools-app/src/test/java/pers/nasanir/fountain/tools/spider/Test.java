package pers.nasanir.fountain.tools.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.finder.service.FindServiceImpl;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Test extends ApplicationTests {
    @Autowired
    private FindServiceImpl findService;

    @org.junit.Test
    public void start() throws ExecutionException, InterruptedException {
        String msg="{\"frontUrl\":\"\",\"frontUuid\":\"\",\"page\":\"\",\"url\":\"http://maintenance.ushayden.com\n" +
                "\",\"uuid\":\"183BE63CE1F2E69DBB6B0003A1948DE751D78995D0FD1B68863A4B620952FE00\"}";
    }
}
