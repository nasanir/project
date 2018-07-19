package pers.nasanir.fountain.common.sql.itf;

import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.sql.entity.SqlVO;

import java.util.HashMap;
import java.util.List;

public interface ISqlbuilder {
	public SqlVO getQuerySql(AbstractVO vo);

	public List<String> getCreateSql(HashMap<String,ClassInfo> classInfoMap);
}
