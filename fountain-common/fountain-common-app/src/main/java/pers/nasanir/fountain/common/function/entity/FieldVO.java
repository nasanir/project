package pers.nasanir.fountain.common.function.entity;

import pers.nasanir.fountain.common.common.entity.BaseVO;

import java.util.Date;

public class FieldVO extends BaseVO {
    private Long fieldId;

    private String functionCode;

    private String fieldCode;

    private String fieldName;

    private String fieldType;

    private Integer fieldLen;

    private Integer fieldOrder;

    private Boolean isvaild;

    private String description;

    private Date createdDt;

    private String createdBy;

    private Date changeDt;

    private String changeBy;

    private static final long serialVersionUID = 1L;

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public Integer getFieldLen() {
        return fieldLen;
    }

    public void setFieldLen(Integer fieldLen) {
        this.fieldLen = fieldLen;
    }

    public Integer getFieldOrder() {
        return fieldOrder;
    }

    public void setFieldOrder(Integer fieldOrder) {
        this.fieldOrder = fieldOrder;
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