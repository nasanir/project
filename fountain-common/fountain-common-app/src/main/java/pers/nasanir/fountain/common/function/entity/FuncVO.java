package pers.nasanir.fountain.common.function.entity;

import pers.nasanir.fountain.common.common.entity.BaseVO;

import java.util.Date;

public class FuncVO extends BaseVO {
    private Long functionId;

    private String tableName;

    private String functionCode;

    private String functionName;

    private String functionEntity;

    private String funcWhere;

    private String orderBy;

    private Boolean isvaild;

    private String description;

    private Date createdDt;

    private String createdBy;

    private Date changeDt;

    private String changeBy;

    private static final long serialVersionUID = 1L;

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionEntity() {
        return functionEntity;
    }

    public void setFunctionEntity(String functionEntity) {
        this.functionEntity = functionEntity == null ? null : functionEntity.trim();
    }

    public String getFuncWhere() {
        return funcWhere;
    }

    public void setFuncWhere(String funcWhere) {
        this.funcWhere = funcWhere == null ? null : funcWhere.trim();
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy == null ? null : orderBy.trim();
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

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
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