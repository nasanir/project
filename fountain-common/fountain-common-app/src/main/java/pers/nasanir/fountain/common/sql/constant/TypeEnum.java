package pers.nasanir.fountain.common.sql.constant;

public enum TypeEnum {
    MYSQLVACHAR("VACHAR"),
    MYSQLDATETIME("DATETIME"),
    MYSQLBIGINT("BIGINT"),
    MYSQLINT("INT"),
    MYSQLBIT("BIT")
    ;


    private String type;

    TypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }
}
