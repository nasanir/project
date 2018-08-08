package pers.nasanir.fountain.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.db.orm.JdbcBaseDao;

@Service("jdbcBaseService")
public class JdbcBaseServiceImpl implements IJdbcBaseService {

	@Autowired
	private JdbcBaseDao jdbcBaseDao;

	public AbstractVO query(QueryVO vo) {
		// TODO Auto-generated method stub
		vo= (QueryVO) jdbcBaseDao.query(vo);
		return vo;
	}

}
