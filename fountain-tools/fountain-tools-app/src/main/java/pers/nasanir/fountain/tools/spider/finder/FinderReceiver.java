package pers.nasanir.fountain.tools.spider.finder;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.nasanir.fountain.tools.json.mapper.JsonMapper;
import pers.nasanir.fountain.tools.spider.finder.entity.SpiderVO;
import pers.nasanir.fountain.tools.spider.finder.service.FindServiceImpl;
import pers.nasanir.fountain.tools.spider.sender.config.MQConfig;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Component
@RabbitListener(queues = MQConfig.FINDER_QUEUE)
public class FinderReceiver {
    @Autowired
    private FindServiceImpl findService;

    @RabbitHandler
    public void process(String msg) throws ExecutionException, InterruptedException {
        HashMap<String, SpiderVO> spiderVOMap = (HashMap<String, SpiderVO>) JsonMapper.json2Obj(new HashMap<String, SpiderVO>(),msg);
        findService.findStart(spiderVOMap);
    }
}
