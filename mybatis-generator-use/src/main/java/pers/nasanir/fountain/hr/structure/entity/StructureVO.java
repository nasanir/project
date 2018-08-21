package pers.nasanir.fountain.hr.structure.entity;

import java.io.Serializable;
import java.util.Date;

public class StructureVO implements Serializable {
    private Long structureId;

    private String structureCode;

    private String structureName;

    private String parentCode;

    private Integer structureOrder;

    private Integer structureLayer;

    private Boolean isvaild;

    private String description;

    private Date createDt;

    private String createBy;

    private Date changeDt;

    private String changeBy;

    private static final long serialVersionUID = 1L;

    public Long getStructureId() {
        return structureId;
    }

    public void setStructureId(Long structureId) {
        this.structureId = structureId;
    }

    public String getStructureCode() {
        return structureCode;
    }

    public void setStructureCode(String structureCode) {
        this.structureCode = structureCode == null ? null : structureCode.trim();
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName == null ? null : structureName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getStructureOrder() {
        return structureOrder;
    }

    public void setStructureOrder(Integer structureOrder) {
        this.structureOrder = structureOrder;
    }

    public Integer getStructureLayer() {
        return structureLayer;
    }

    public void setStructureLayer(Integer structureLayer) {
        this.structureLayer = structureLayer;
    }

    public Boolean getIsvaild() {
        return isvaild;
    }

    public void setIsvaild(Boolean isvaild) {
        this.isvaild = isvaild;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getChangeDt() {
        return changeDt;
    }

    public void setChangeDt(Date changeDt) {
        this.changeDt = changeDt;
    }

    public String getChangeBy() {
        return changeBy;
    }

    public void setChangeBy(String changeBy) {
        this.changeBy = changeBy == null ? null : changeBy.trim();
    }
}