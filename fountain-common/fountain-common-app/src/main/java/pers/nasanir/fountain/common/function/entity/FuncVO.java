package pers.nasanir.fountain.common.function.entity;

import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.BaseVO;

import java.util.Date;

@PeaceTable(name = "fountian_common_func",isView = false)
public class FuncVO extends BaseVO {
    public Long fountian_common_func_id;
    public String func_code;
    public String func_name;
    public String func_class_path;
    public String func_where;
    public Integer isValid;
    public Date create_date;

    public Long getFountian_common_func_id() {
        return fountian_common_func_id;
    }

    public void setFountian_common_func_id(Long fountian_common_func_id) {
        this.fountian_common_func_id = fountian_common_func_id;
    }

    public String getFunc_code() {
        return func_code;
    }

    public void setFunc_code(String func_code) {
        this.func_code = func_code;
    }

    public String getFunc_name() {
        return func_name;
    }

    public void setFunc_name(String func_name) {
        this.func_name = func_name;
    }

    public String getFunc_class_path() {
        return func_class_path;
    }

    public void setFunc_class_path(String func_class_path) {
        this.func_class_path = func_class_path;
    }

    public String getFunc_where() {
        return func_where;
    }

    public void setFunc_where(String func_where) {
        this.func_where = func_where;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
