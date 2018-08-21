package pers.nasanir.fountain.common.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.nasanir.fountain.common.db.entity.SequenceVO;
@Mapper
public interface SequenceVOMapper {
    int deleteByPrimaryKey(Long sequenceId);

    int insert(SequenceVO record);

    int insertSelective(SequenceVO record);

    SequenceVO selectByCode(String sequenceCode);

    int updateByPrimaryKeySelective(SequenceVO record);

    int updateByPrimaryKey(SequenceVO record);
}