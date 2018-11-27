package pers.nasanir.fountain.tools.spider.reader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.sender.SpiderSender;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

@Component
public class SpiderReader
//        implements InitializingBean,DisposableBean
{

    @Autowired
    private SpiderSender spiderSender;

    private ExecutorService executor;

    public void analysis(String obj) {
        SpiderVO spiderVO = JSON.parseObject(obj, SpiderVO.class);
        analysis(spiderVO);
    }

    public void analysis(SpiderVO spiderVO){
        HashMap<String,SpiderVO> spiderVOHashMap=new HashMap<String, SpiderVO>();
        if (spiderVO != null) {
            String page = spiderVO.getPage();
            findAnchors(page,spiderVO,spiderVOHashMap);
        }

        if(spiderVOHashMap.size()>0){
            spiderSender.send2Finder(spiderVOHashMap);
        }
    }

    public void findAnchors(String htmlPage,SpiderVO VO,HashMap<String,SpiderVO> spiderVOHashMap) {
//        List<HtmlAnchor> anchorList = htmlPage.getAnchors();
//        for (HtmlAnchor a : anchorList) {
//            String herfUrl = a.getHrefAttribute();
//            SpiderVO spiderVO=new SpiderVO();
//            spiderVO.setFrontUrl(VO.getUrl());
//            spiderVO.setFrontUuid(VO.getUuid());
//            spiderVO.setUrl(herfUrl);
//            spiderVOHashMap.put(spiderVO.getUuid(),spiderVO);
//        }
    }
//
//    public void destroy() throws Exception {
//        if(executor!=null){
//            executor.shutdown();
//            executor.awaitTermination(5,TimeUnit.MINUTES);
//        }
//    }
//
//    public void afterPropertiesSet() throws Exception {
//        if(executor==null){
//            executor=new ThreadPoolExecutor(15, 200, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
//                public Thread newThread(Runnable r) {
//                    return new Thread(r,"reader analysis "+Thread.currentThread().getId());
//                }
//            });
//        }
//
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                if(executor!=null){
//                    try {
//                        executor.shutdown();
//                        executor.awaitTermination(5,TimeUnit.MINUTES);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
}
