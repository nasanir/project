package pers.nasanir.fountain.common.sql.itf;

import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.sql.entity.SqlVO;

public interface ISqlbuilder {
	public SqlVO getQuerySql(AbstractVO vo);
}
