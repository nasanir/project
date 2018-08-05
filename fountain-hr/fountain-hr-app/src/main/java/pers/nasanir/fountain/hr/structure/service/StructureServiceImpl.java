package pers.nasanir.fountain.hr.structure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;
import pers.nasanir.fountain.hr.structure.itf.IStructureService;
import pers.nasanir.fountain.hr.structure.mapper.StructureVOMapper;

import java.util.List;
@Service("structureService")
public class StructureServiceImpl implements IStructureService {
    @Autowired
    private StructureVOMapper structureVOMapper;

    @Override
    public List<StructureVO> getData() {
        List<StructureVO> users = structureVOMapper.selectAll();
        return users;
    }
}
