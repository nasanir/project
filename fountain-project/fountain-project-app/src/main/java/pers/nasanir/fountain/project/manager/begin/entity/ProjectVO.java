package pers.nasanir.fountain.project.manager.begin.entity;

import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.BaseVO;

import java.util.Date;

@PeaceTable(name="fountain_project")
public class ProjectVO extends BaseVO {
    @PeaceField(isPk = true)
    private long fountain_project_id;
    @PeaceField
    private String fountain_procject_code;
    @PeaceField
    private String fountain_project_name;
    @PeaceField
    private String project_manager_code;
    @PeaceField
    private String project_manager_name;
    @PeaceField
    private Date create_date;
    @PeaceField
    private String description;
    @PeaceField
    private String status;
    @PeaceField
    private String country_code;
    @PeaceField
    private String country_name;
    @PeaceField
    private String city_code;
    @PeaceField
    private String city_name;
    @PeaceField
    private String commision;

    public long getFountain_project_id() {
        return fountain_project_id;
    }

    public void setFountain_project_id(long fountain_project_id) {
        this.fountain_project_id = fountain_project_id;
    }

    public String getFountain_procject_code() {
        return fountain_procject_code;
    }

    public void setFountain_procject_code(String fountain_procject_code) {
        this.fountain_procject_code = fountain_procject_code;
    }

    public String getFountain_project_name() {
        return fountain_project_name;
    }

    public void setFountain_project_name(String fountain_project_name) {
        this.fountain_project_name = fountain_project_name;
    }

    public String getProject_manager_code() {
        return project_manager_code;
    }

    public void setProject_manager_code(String project_manager_code) {
        this.project_manager_code = project_manager_code;
    }

    public String getProject_manager_name() {
        return project_manager_name;
    }

    public void setProject_manager_name(String project_manager_name) {
        this.project_manager_name = project_manager_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCommision() {
        return commision;
    }

    public void setCommision(String commision) {
        this.commision = commision;
    }
}
