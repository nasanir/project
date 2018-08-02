package pers.nasanir.fountain.common.sql.constant;

public class DbConstant {
	public static final String SQLSTRAT="select * from ";
	public static final String CREATESQL="create table ${tableName} (${fieldName});";

	public static final String ARG_TABLENAME="${tableName}";
	public static final String ARG_FIELDNAME="${fieldName}";

	public static final String SIGN_BLANK=" ";
	public static final String SIGN_COMMA=",";
	public static final String SIGN_LEFT_BRACKET="(";
	public static final String SIGN_RIGHT_BRACKET=")";
	public static final String SIGN_SEMICOLON=";";

	public static final String KEY_NOTNUL="NOT NULL";
	public static final String KEY_PRIMARY="PRIMARY KEY";
}
