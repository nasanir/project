package pers.nasanir.fountain.common.sql.constant;

public class DbConstant {
	public static final String SQL_SELECT="select ${field} from ${tableName} ${where} ${groupby} ${orderby}";
	public static final String SQL_CREATE="create table ${tableName} (${fieldName});";
	public static final String SQL_INSERT="insert into ${tableName} (${fieldAll}) values ${values}";

	public static final String ARG_TABLENAME="${tableName}";
	public static final String ARG_FIELDNAME="${fieldName}";
	public static final String ARG_WHERE="${where}";
	public static final String ARG_GROUPBY="${groupby}";
	public static final String ARG_ORDERBY="${orderby}";
	public static final String ARG_FIELD="${field}";
	public static final String ARG_FIELDALL="${fieldAll}";
	public static final String ARG_VALUES="${values}";


	public static final String SIGN_BLANK=" ";
	public static final String SIGN_COMMA=",";
	public static final String SIGN_LEFT_BRACKET="(";
	public static final String SIGN_RIGHT_BRACKET=")";
	public static final String SIGN_SEMICOLON=";";
	public static final String SIGN_SIGQUOT="'";
	public static final String SIGN_UNDERLINE="_";
	public static final String SIGN_BIT="b";
	public static final String SIGN_BACKQUOT="`";

	public static final String KEY_NOTNUL="NOT NULL";
	public static final String KEY_PRIMARY="PRIMARY KEY";
	public static final String KEY_GROUPBY="GROUP BY ";
	public static final String KEY_ORDERBY="ORDER BY ";
	public static final String KEY_WHERE="WHERE ";
	public static final String KEY_AND=" AND ";



	public static final int LEN_SELECT=16;
}
