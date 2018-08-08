package pers.nasanir.fountain.common.common.mapper;

import pers.nasanir.fountain.common.common.entity.FieldVO;

import java.util.List;

public interface FieldVOMapper {
    int deleteByPrimaryKey(Long fieldId);

    int insert(FieldVO record);

    int insertSelective(FieldVO record);

    FieldVO selectByPrimaryKey(Long fieldId);

    List<FieldVO> selectByCode(String functionCode);

    int updateByPrimaryKeySelective(FieldVO record);

    int updateByPrimaryKey(FieldVO record);
}