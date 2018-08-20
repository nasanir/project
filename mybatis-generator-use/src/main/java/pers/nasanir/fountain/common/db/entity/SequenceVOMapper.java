package pers.nasanir.fountain.common.db.entity;

import pers.nasanir.fountain.common.db.entity.SequenceVO;

public interface SequenceVOMapper {
    int deleteByPrimaryKey(Long sequenceId);

    int insert(SequenceVO record);

    int insertSelective(SequenceVO record);

    SequenceVO selectByPrimaryKey(Long sequenceId);

    int updateByPrimaryKeySelective(SequenceVO record);

    int updateByPrimaryKey(SequenceVO record);
}