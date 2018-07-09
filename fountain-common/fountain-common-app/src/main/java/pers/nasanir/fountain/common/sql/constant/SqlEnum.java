package pers.nasanir.fountain.common.sql.constant;

public enum SqlEnum {
	MYSQL("MysqlSqlBuilder");

	private String className;

	SqlEnum(String className) {
		this.className = className;
	}

	public String getName() {
		return this.className;
	}

}
