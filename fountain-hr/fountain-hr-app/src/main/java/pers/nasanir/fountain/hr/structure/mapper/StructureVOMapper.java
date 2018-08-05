package pers.nasanir.fountain.hr.structure.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;

import java.util.List;
@Mapper
public interface StructureVOMapper {
    int deleteByPrimaryKey(Long structureId);

    int insert(StructureVO record);

    int insertSelective(StructureVO record);

    StructureVO selectByPrimaryKey(Long structureId);

    int updateByPrimaryKeySelective(StructureVO record);

    int updateByPrimaryKey(StructureVO record);

    List<StructureVO> selectAll();
}