package pers.nasanir.fountain.common.sql.factroy;


import pers.nasanir.fountain.common.sql.itf.ISqlbuilder;

public class SqlFactroy {


    public static ISqlbuilder createSqlBuilder() {
        return SqlManager.getSqlBuilder("mysql");
    }
}
