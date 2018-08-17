package pers.nasanir.fountain.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.common.entity.VOSet;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.db.orm.JdbcBaseDao;

import java.util.List;

@Service("jdbcBaseService")
public class JdbcBaseServiceImpl implements IJdbcBaseService {

	@Autowired
	private JdbcBaseDao jdbcBaseDao;

	public VOSet query(QueryVO vo) {
		// TODO Auto-generated method stub
		VOSet voSet=  jdbcBaseDao.query(vo);
		return voSet;
	}

	@Override
	public void add(DataVO vo) {
		jdbcBaseDao.add(vo);
	}

}
