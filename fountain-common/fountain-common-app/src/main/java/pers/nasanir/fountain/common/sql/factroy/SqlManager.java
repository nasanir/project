package pers.nasanir.fountain.common.sql.factroy;




import pers.nasanir.fountain.common.sql.itf.ISqlbuilder;
import pers.nasanir.fountain.common.sql.service.MysqlSqlBuilder;

import java.util.HashMap;

public class SqlManager {
	public static ISqlbuilder getSqlBuilder(String type){
		HashMap<String, ISqlbuilder> typeMap=new HashMap<String,ISqlbuilder>();
		typeMap.put("mysql", new MysqlSqlBuilder());
		return typeMap.get(type);
	}
}
