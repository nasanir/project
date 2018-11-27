package pers.nasanir.fountain.tools.spider.sender.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MQConfig {
    public static final String READER_QUEUE="spiderReaderQue";
    public static final String FINDER_QUEUE="spiderFinderQue";

    @Bean
    public Queue readerQueue(){
        return new Queue(READER_QUEUE);
    }

    @Bean
    public Queue finderQueue(){
        return new Queue(FINDER_QUEUE);
    }
}
