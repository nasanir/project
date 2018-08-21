package pers.nasanir.fountain.hr.structure.itf;

import pers.nasanir.fountain.common.common.entity.ParamterVO;
import pers.nasanir.fountain.common.common.entity.ResultVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.hr.structure.entity.StructureVO;

import java.util.List;

public interface IStructureService {
    public ResultVO showList(ParamterVO vo);

    public ResultVO add(ParamterVO vo);

    public ResultVO save(ParamterVO vo);
}
