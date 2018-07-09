package pers.nasanir.fountain.common.sql.entity;

import java.util.List;

public class SqlVO {
	private String sql;
	private List<Object> argList;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<Object> getArgList() {
		return argList;
	}

	public void setArgList(List<Object> argList) {
		this.argList = argList;
	}

}
