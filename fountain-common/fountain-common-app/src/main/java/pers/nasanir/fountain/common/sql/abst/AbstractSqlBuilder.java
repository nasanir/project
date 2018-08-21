package pers.nasanir.fountain.common.sql.abst;


import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.constant.DbConstant;
import pers.nasanir.fountain.common.sql.itf.ISqlbuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public abstract class AbstractSqlBuilder implements ISqlbuilder {
	@Override
	public abstract String getQuerySql(QueryVO vo);

	@Override
	public abstract String getInsertSql(DataVO vo);

	@Override
	public abstract String getUpdate(DataVO vo);

//	@Override
//	public abstract List<String> getCreateSql(HashMap<String,ClassInfo> classInfoMap);

	public String fieldToVo(String field) {
		String[] voFieldArr=field.split(DbConstant.SIGN_UNDERLINE);
		StringBuffer fieldBf=new StringBuffer();
		for(int i=0;i<voFieldArr.length;i++){
			String fieldPart=voFieldArr[i].toLowerCase(Locale.ROOT);
			if(i!=0){
				fieldPart=Character.toUpperCase(fieldPart.charAt(0))+fieldPart.substring(CommonConstant.STR_SUBFIRST);
			}
			fieldBf.append(fieldPart);
		}
		return fieldBf.toString();
	}

	public abstract String typeDbToJ(Object value,String type);

}
