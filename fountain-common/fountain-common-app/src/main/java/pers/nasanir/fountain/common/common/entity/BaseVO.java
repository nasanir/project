package pers.nasanir.fountain.common.common.entity;

import java.util.Date;

public class BaseVO extends AbstractVO {

    private Date create_date;

    private String create_by;

    private Date change_date;

    private String change_by;

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getChange_date() {
        return change_date;
    }

    public void setChange_date(Date change_date) {
        this.change_date = change_date;
    }

    public String getChange_by() {
        return change_by;
    }

    public void setChange_by(String change_by) {
        this.change_by = change_by;
    }
}
