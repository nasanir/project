package pers.nasanir.fountain.manager.function.mapper;

import pers.nasanir.fountain.manager.function.entity.FuncVO;

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