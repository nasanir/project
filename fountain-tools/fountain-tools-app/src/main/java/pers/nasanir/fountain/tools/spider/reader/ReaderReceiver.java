package pers.nasanir.fountain.tools.spider.reader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.nasanir.fountain.tools.json.mapper.JsonMapper;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.reader.service.ReaderServiceImpl;
import pers.nasanir.fountain.tools.spider.sender.config.MQConfig;

import java.util.HashMap;

@Component
@RabbitListener(queues = MQConfig.READER_QUEUE)
public class ReaderReceiver {

    @Autowired
    private ReaderServiceImpl readerService;

    @RabbitHandler
    public void process(String msg) {
        SpiderVO spiderVO = (SpiderVO) JsonMapper.json2Obj(new SpiderVO(),msg);
        readerService.read(spiderVO);
    }

}