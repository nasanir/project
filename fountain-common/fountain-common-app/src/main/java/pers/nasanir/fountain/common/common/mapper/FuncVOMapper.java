package pers.nasanir.fountain.common.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.nasanir.fountain.common.common.entity.FuncVO;
@Mapper
public interface FuncVOMapper {
    int deleteByPrimaryKey(Long functionId);

    int insert(FuncVO record);

    int insertSelective(FuncVO record);

    FuncVO selectByPrimaryKey(Long functionId);

    FuncVO selectByCode(String functionCode);

    FuncVO selectByName(String functionName);

    int updateByPrimaryKeySelective(FuncVO record);

    int updateByPrimaryKey(FuncVO record);
}