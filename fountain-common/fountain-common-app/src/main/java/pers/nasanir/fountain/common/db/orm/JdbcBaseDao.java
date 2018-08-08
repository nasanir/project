package pers.nasanir.fountain.common.db.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.db.impl.CrudDao;

import java.util.HashMap;
import java.util.List;

/**
 * 通用查询dao层
 * 
 * @author nasanir
 *
 */
@Repository("jdbcBaseDao")
public class JdbcBaseDao {
	@Autowired
	private CrudDao crudDao;

	public AbstractVO query(QueryVO vo) {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> valueList = crudDao.query(vo);
		return vo;
	}

	private List<AbstractVO> transFormData(List<HashMap<String, Object>> valueList) {
		return null;
	}

}
