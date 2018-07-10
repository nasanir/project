package pers.nasanir.fountain.project.manager.begin.entity;

import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.BaseVO;

@PeaceTable(name="fountain_project")
public class ProjectVO extends BaseVO {
    @PeaceField(isPk = true)
    private long fountain_project_id;
    private String fountain_procject_code;

}
