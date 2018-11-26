package pers.nasanir.fountain.tools.spider.sender.service;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.omg.SendingContext.RunTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import pers.nasanir.fountain.tools.spider.finder.SpinderFinder;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.finder.itf.FindService;
import pers.nasanir.fountain.tools.spider.sender.SpiderSender;

import java.util.HashMap;
import java.util.concurrent.*;

public class SenderServiceImpl implements InitializingBean,DisposableBean {

    private static final Logger logger=LoggerFactory.getLogger(SenderServiceImpl.class);

    private ExecutorService executor;
    @Override
    public void destroy() throws Exception {
        if(executor!=null){
            executor.shutdown();
            executor.awaitTermination(5,TimeUnit.MINUTES);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(executor==null){
            executor=new ThreadPoolExecutor(15, 200, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r,"SpiderSender executor thread"+Thread.currentThread().getId());
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
                    logger.warn("s");
                }
            }
        });
    }

    public void Send(final HashMap<String,Future<HtmlPage>> futureMap,final HashMap<String,SpiderVO> spiderVOMap) throws ExecutionException, InterruptedException {
        for(final String uuid:futureMap.keySet()){
            Future<String> future=this.executor.submit(new Callable<String>(){
                public String call() throws Exception {
                    Future<HtmlPage> spiderfuture=futureMap.get(uuid);
                    while(!spiderfuture.isDone()){

                    }
                    SpiderVO spiderVO=spiderVOMap.get(uuid);
                    spiderVO.setPage(spiderfuture.get().getPage());
                    SpiderSender spiderSender=new SpiderSender();
                    spiderSender.send(spiderVO);
                    return "success";
                }
            });
        }

    }
}
