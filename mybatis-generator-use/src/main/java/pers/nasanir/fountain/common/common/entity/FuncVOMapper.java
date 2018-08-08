package pers.nasanir.fountain.common.common.entity;

import pers.nasanir.fountain.common.common.entity.FuncVO;

public interface FuncVOMapper {
    int deleteByPrimaryKey(Long functionId);

    int insert(FuncVO record);

    int insertSelective(FuncVO record);

    FuncVO selectByPrimaryKey(Long functionId);

    int updateByPrimaryKeySelective(FuncVO record);

    int updateByPrimaryKey(FuncVO record);
}