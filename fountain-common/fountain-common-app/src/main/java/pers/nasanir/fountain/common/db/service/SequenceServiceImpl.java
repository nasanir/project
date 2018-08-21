package pers.nasanir.fountain.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.entity.SequenceVO;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.db.impl.ISequenceService;
import pers.nasanir.fountain.common.db.mapper.SequenceVOMapper;
import pers.nasanir.fountain.common.exception.BaseRunTimeException;

import java.util.HashMap;


@Service("sequenceService")
public class SequenceServiceImpl implements ISequenceService {
    @Autowired
    SequenceVOMapper sequenceVOMapper;

    static final String DEFAULT_CODE="COMMON_SEQUENCE";
    static Object LOCK=new Object();
    static HashMap<String,SequenceVO> sequenceCacheMap=new HashMap<>();

    public Long generator(){
        return generator(DEFAULT_CODE);
    }

    public Long generator(String sequenceCode){
        synchronized (LOCK){
            if(sequenceCode!=null&&sequenceCode.length()>0){
                return getNextId(sequenceCode);
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
            return refreshSequenceCache(sequenceCode);
        }
    }

    public Long refreshSequenceCache(String sequenceCode){
        SequenceVO sequenceVO=sequenceVOMapper.selectByCode(sequenceCode);
        if(sequenceVO!=null){
            Long nextId=sequenceVO.getSequenceNext();
            sequenceVO.setSequenceNext(nextId+sequenceVO.getSequenceCache()+1L);
            sequenceVOMapper.updateByPrimaryKeySelective(sequenceVO);
            sequenceVO.setSequenceNext(nextId+1L);
            sequenceVO.setCount(1);
            sequenceCacheMap.put(sequenceCode,sequenceVO);
            return nextId;
        }else{
            throw new BaseRunTimeException("please confige sequence first");
        }
    }
}
