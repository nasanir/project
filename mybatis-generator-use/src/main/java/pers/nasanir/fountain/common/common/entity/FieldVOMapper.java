package pers.nasanir.fountain.common.common.entity;

import pers.nasanir.fountain.common.common.entity.FieldVO;

public interface FieldVOMapper {
    int deleteByPrimaryKey(Long fieldId);

    int insert(FieldVO record);

    int insertSelective(FieldVO record);

    FieldVO selectByPrimaryKey(Long fieldId);

    int updateByPrimaryKeySelective(FieldVO record);

    int updateByPrimaryKey(FieldVO record);
}