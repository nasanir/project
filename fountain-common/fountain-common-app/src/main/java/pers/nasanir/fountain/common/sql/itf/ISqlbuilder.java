package pers.nasanir.fountain.common.sql.itf;

import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.entity.SqlVO;

import java.util.HashMap;
import java.util.List;

public interface ISqlbuilder {
	public String getQuerySql(QueryVO vo);

	public String getInsertSql(DataVO vo);

	public List<String> getCreateSql(HashMap<String,ClassInfo> classInfoMap);
}
