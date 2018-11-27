package pers.nasanir.fountain.tools.spider.reader.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.reader.SpiderReader;

import java.util.concurrent.*;
@Service("readerService")
public class ReaderServiceImpl implements InitializingBean,DisposableBean {

    @Autowired
    private SpiderReader spiderReader;

    private ExecutorService executor;

    public void destroy() throws Exception {
        if(executor!=null){
            executor.shutdown();
            executor.awaitTermination(5,TimeUnit.MINUTES);
        }
    }

    public void afterPropertiesSet() throws Exception {
        if(executor==null){
            executor=new ThreadPoolExecutor(15, 200, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    return new Thread(r,"SpiderReader executor thread"+Thread.currentThread().getId());
                }
            });
        }

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                if(executor!=null){
                    executor.shutdown();
                    try {
                        executor.awaitTermination(5,TimeUnit.MINUTES);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void read(final SpiderVO spiderVO){
        Future<String> future=this.executor.submit(new Callable<String>(){
            public String call() throws Exception {
                spiderReader.analysis(spiderVO);
                return "success";
            }
        });
    }
}
