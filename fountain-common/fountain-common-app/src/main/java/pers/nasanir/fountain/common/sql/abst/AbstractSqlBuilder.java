package pers.nasanir.fountain.common.sql.abst;

import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.sql.constant.DbConstant;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.reflect.Invoker;
import pers.nasanir.fountain.common.sql.entity.SqlVO;
import pers.nasanir.fountain.common.sql.itf.ISqlbuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractSqlBuilder implements ISqlbuilder {
	@Override
	public abstract String getQuerySql(QueryVO vo);
	@Override
	public abstract List<String> getCreateSql(HashMap<String,ClassInfo> classInfoMap);

}
