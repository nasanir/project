package pers.nasanir.fountain.tools.spider.sender;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.tools.spider.sender.config.MQConfig;

@Service
public class SpiderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        amqpTemplate.convertAndSend(MQConfig.QUEUE,msg);
    }

    public void send(Object obj){
        String jsonStr=JSONObject.toJSONString(obj);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,jsonStr);
    }
}
