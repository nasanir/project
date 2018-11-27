package pers.nasanir.fountain.tools.spider;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.finder.service.FindServiceImpl;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class SpiderTest extends ApplicationTests {
    @Autowired
    private FindServiceImpl findService;

    @Test
    public void start() throws ExecutionException, InterruptedException {
        HashMap<String,SpiderVO> spiderVOMap=new HashMap<String, SpiderVO>();
        String[] urlArr={"http://maintenance.ushayden.com/"};

        for(String str:urlArr){
            SpiderVO spiderVO=new SpiderVO();
            spiderVO.setUrl(str);
            spiderVOMap.put(spiderVO.getUuid(),spiderVO);
        }
        findService.findStart(spiderVOMap);
    }
}
