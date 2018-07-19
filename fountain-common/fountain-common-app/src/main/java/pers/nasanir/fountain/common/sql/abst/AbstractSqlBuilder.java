package pers.nasanir.fountain.common.sql.abst;

import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
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
	private ArrayList<String> valueList = new ArrayList<String>();

	@Override
	public SqlVO getQuerySql(AbstractVO vo) {
		// TODO Auto-generated method stub
		SqlVO sqlVO=new SqlVO();
		ClassInfo classInfo = ClassInfo.forClass(vo.getClass());
		String whereCaluse = "";
		try {
			whereCaluse = getWhereCaluse(classInfo,vo);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PeaceTable tableAnno = (PeaceTable) classInfo.getAnnotation(PeaceTable.class);
		if (tableAnno != null) {
			String tableName = tableAnno.name();
			if (!tableName.equals("")) {
				StringBuffer sql = new StringBuffer(
						DbConstant.SQLSTRAT.length() + tableName.length() + whereCaluse.length());
				sql.append(DbConstant.SQLSTRAT).append(tableName);
				if (!whereCaluse.equals("")) {
					sql.append(whereCaluse);
				}
				sqlVO.setSql(sql.toString());
			}
		}
		return sqlVO;
	}

	private String getWhereCaluse(ClassInfo classInfo,AbstractVO vo)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer whereCaluse = new StringBuffer();
		if (classInfo.getClz().getDeclaredFields().length > 0) {
			whereCaluse.append(" where ");
			for (Field field : classInfo.getClz().getDeclaredFields()) {
				field.setAccessible(true);

				String fieldName = field.getName().toLowerCase();
				String methodName = CommonConstant.GET + field.getName().toLowerCase();
				Invoker invoker = classInfo.getInvokerMap().get(methodName);
				Object[] args = {};
				if (invoker != null) {
					Object value = invoker.invoke(vo, null);
					if (value != null) {
						String valueStr;
						if (field.getType().getName().equals(CommonConstant.DATETYPE)) {
							valueStr = new SimpleDateFormat(CommonConstant.YMDHIS).format(value);
						} else {
							valueStr = String.valueOf(value);
						}
						valueList.add(valueStr);
						if (whereCaluse.length() > 7) {
							whereCaluse.append(" and ");
						}
						whereCaluse.append(fieldName).append("=#{").append(fieldName).append("}");
					}
				}
			}
		} else {
			whereCaluse.append("");
		}

		return whereCaluse.toString();
	}

	public abstract List<String> getCreateSql(HashMap<String,ClassInfo> classInfoMap);

}
