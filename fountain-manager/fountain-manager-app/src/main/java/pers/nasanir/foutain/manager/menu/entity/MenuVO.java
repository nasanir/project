package pers.nasanir.foutain.manager.menu.entity;

import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.BaseVO;

@PeaceTable(name = "FOUNTAIN_MANAGER_MENUS")
public class MenuVO extends BaseVO {
    @PeaceField(isPk = true, lenght = "19", type = "bigint")
    private long menus_id;
    @PeaceField
    private String menus_code;
    @PeaceField
    private String menus_name;
    @PeaceField
    private String parent_code;
    @PeaceField
    private String func_code;

    public long getMenus_id() {
        return menus_id;
    }

    public void setMenus_id(long menus_id) {
        this.menus_id = menus_id;
    }

    public String getMenus_code() {
        return menus_code;
    }

    public void setMenus_code(String menus_code) {
        this.menus_code = menus_code;
    }

    public String getMenus_name() {
        return menus_name;
    }

    public void setMenus_name(String menus_name) {
        this.menus_name = menus_name;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public String getFunc_code() {
        return func_code;
    }

    public void setFunc_code(String func_code) {
        this.func_code = func_code;
    }

    public int getMenus_order() {
        return menus_order;
    }

    public void setMenus_order(int menus_order) {
        this.menus_order = menus_order;
    }

    public int getMenus_layer() {
        return menus_layer;
    }

    public void setMenus_layer(int menus_layer) {
        this.menus_layer = menus_layer;
    }

    public boolean isIsvaild() {
        return isvaild;
    }

    public void setIsvaild(boolean isvaild) {
        this.isvaild = isvaild;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @PeaceField(lenght = "5", type = "int")
    private int menus_order;
    @PeaceField(lenght = "2", type = "int")
    private int menus_layer;
    @PeaceField(lenght = "1", type = "tinyint")
    private boolean isvaild;
    @PeaceField
    private String type;
}
