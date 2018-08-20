package pers.nasanir.fountain.common.db.entity;

import java.io.Serializable;
import java.util.Date;

public class SequenceVO implements Serializable {
    private Long sequenceId;

    private String sequenceCode;

    private Long sequenceNext;

    private Integer sequenceCache;

    private Date createDt;

    private String createBy;

    private Date changeDt;

    private String changeBy;

    private static final long serialVersionUID = 1L;

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getSequenceCode() {
        return sequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode == null ? null : sequenceCode.trim();
    }

    public Long getSequenceNext() {
        return sequenceNext;
    }

    public void setSequenceNext(Long sequenceNext) {
        this.sequenceNext = sequenceNext;
    }

    public Integer getSequenceCache() {
        return sequenceCache;
    }

    public void setSequenceCache(Integer sequenceCache) {
        this.sequenceCache = sequenceCache;
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