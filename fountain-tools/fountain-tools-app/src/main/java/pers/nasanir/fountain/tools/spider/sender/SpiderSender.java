package pers.nasanir.fountain.tools.spider.sender;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.tools.json.mapper.JsonMapper;
import pers.nasanir.fountain.tools.spider.sender.config.MQConfig;

@Component
public class SpiderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send2Finder(Object obj){
        String jsonStr= JsonMapper.obj2Json(obj);
        amqpTemplate.convertAndSend(MQConfig.FINDER_QUEUE,jsonStr);
    }

    public void send2Reader(Object obj){
        String jsonStr= JsonMapper.obj2Json(obj);
        amqpTemplate.convertAndSend(MQConfig.READER_QUEUE,jsonStr);
    }
}
