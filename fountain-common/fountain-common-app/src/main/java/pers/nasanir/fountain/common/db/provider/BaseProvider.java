package pers.nasanir.fountain.common.db.provider;


import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.sql.factroy.SqlFactroy;

public class BaseProvider {
	public String query(QueryVO vo) {
		String sql = SqlFactroy.createSqlBuilder().getQuerySql(vo);
		vo.setSql(sql);
		return sql;
	}
}
