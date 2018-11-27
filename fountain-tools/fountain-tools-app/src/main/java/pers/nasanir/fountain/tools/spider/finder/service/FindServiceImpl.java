package pers.nasanir.fountain.tools.spider.finder.service;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.tools.spider.finder.SpiderFinder;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.sender.SpiderSender;
import pers.nasanir.fountain.tools.spider.sender.service.SenderServiceImpl;

import java.util.*;
import java.util.concurrent.*;
@Service("findService")
public class FindServiceImpl implements DisposableBean,InitializingBean {
    private static final Logger logger=LoggerFactory.getLogger(FindServiceImpl.class);

    @Autowired
    private SpiderFinder spiderFinder;

    @Autowired
    private SenderServiceImpl senderService;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private ExecutorService executor;

    private HashMap<String,Future<HtmlPage>> spiderMap=new HashMap<String,Future<HtmlPage>>();

    public void destroy() throws Exception {
        if(executor!=null){
            executor.shutdown();
            executor.awaitTermination(5,TimeUnit.MINUTES);
        }
    }

    public void afterPropertiesSet() throws Exception {
        if(executor==null){
            executor= new ThreadPoolExecutor(15, 200,
                    60L, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>(),
                    new ThreadFactory() {
                        public Thread newThread(Runnable r) {
                            return new Thread(r,"SpiderFinder executor thread"+Thread.currentThread().getId());
                        }
                    });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                try{
                    if(executor!=null){
                        executor.shutdown();
                        executor.awaitTermination(5,TimeUnit.MINUTES);
                    }
                }catch (InterruptedException e) {
                    logger.warn("");
                }
            }
        });

    }

    public void findStart(HashMap<String,SpiderVO> spiderVOMap) throws ExecutionException, InterruptedException {
      for(String uuid:spiderVOMap.keySet()){
          final String target=spiderVOMap.get(uuid).getUrl();
          if(target!=null&&target.length()>0){
              Future<HtmlPage> future=this.executor.submit(new Callable<HtmlPage>() {
                  public HtmlPage call() throws Exception {
                      logger.info(target);
                      return spiderFinder.startFind(target);
                  }
              });
              spiderMap.put(uuid,future);
          }
      }
      senderService.send2Reader(spiderMap,spiderVOMap);
    }

    class SpiderActiveVO{
        private String url;
        private String frontUrl;
        private Future<HtmlPage> pageFuture;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFrontUrl() {
            return frontUrl;
        }

        public void setFrontUrl(String frontUrl) {
            this.frontUrl = frontUrl;
        }

        public Future<HtmlPage> getPageFuture() {
            return pageFuture;
        }

        public void setPageFuture(Future<HtmlPage> pageFuture) {
            this.pageFuture = pageFuture;
        }
    }

}
