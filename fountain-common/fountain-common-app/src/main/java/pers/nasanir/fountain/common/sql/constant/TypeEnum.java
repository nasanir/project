package pers.nasanir.fountain.common.sql.constant;

public enum TypeEnum {
    MYSQL_VACHAR("VACHAR"),
    MYSQL_DATETIME("DATETIME"),
    MYSQL_BIGINT("BIGINT"),
    MYSQL_INT("INT"),
    MYSQL_BIT("BIT"),
    MYSQL_FALSE("0"),
    MYSQL_TRUE("1")
    ;


    private String type;

    TypeEnum(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }
}
