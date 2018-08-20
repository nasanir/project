package pers.nasanir.fountain.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.entity.SequenceVO;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.db.impl.ISequenceService;
import pers.nasanir.fountain.common.exception.BaseRunTimeException;

import java.util.HashMap;


@Service("sequenceService")
public class SequenceServiceImpl implements ISequenceService {
    @Autowired
    IJdbcBaseService jdbcBaseService;

    static final String DEFAULT_CODE="COMMON_SEQUENCE";
    static Object LOCK=new Object();
    static HashMap<String,SequenceVO> sequenceCacheMap=new HashMap<>();

    public Long generator(String sequenceCode){
        synchronized (LOCK){
            if(sequenceCode!=null&&sequenceCode.length()>0){

            }else{
                throw new BaseRunTimeException("sequenceCode is reuqire");
            }
        }
    }

    public long getNextId(String sequenceCode){
        SequenceVO sequenceVO=sequenceCacheMap.get(sequenceCode);
        if(sequenceVO!=null&&sequenceVO.getCount()<sequenceVO.getSequenceCache()){
            Long nextId=sequenceVO.getSequenceNext();
            sequenceVO.setSequenceNext(nextId+1L);
            sequenceVO.setCount(sequenceVO.getCount()+1);
            return nextId;
        }else{

        }
    }

    public Long refreshSequenceCache(String sequenceCode){
        QueryVO queryVO=new QueryVO();
        queryVO.setFuncCode(DEFAULT_CODE);
        queryVO.setWhere(" SEQUENCE_CODE='"+sequenceCode+"'");
        VOSet<SequenceVO> seqSet=jdbcBaseService.query(queryVO);
        if(seqSet!=null&&!seqSet.isEmpty()){
            SequenceVO sequenceVO=seqSet.getVoList().get(0);
            Long nextId=sequenceVO.getSequenceNext();
            sequenceVO.setSequenceNext(nextId+sequenceVO.getSequenceCache()+1L);
            jdbcBaseService.

            sequenceCacheMap.put(sequenceCode,sequenceVO);

        }
    }
}
