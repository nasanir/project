package pers.nasanir.fountain.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.db.impl.IJdbcBaseService;
import pers.nasanir.fountain.common.db.orm.JdbcBaseDao;

import java.util.HashMap;
import java.util.List;

@Service("jdbcBaseService")
public class JdbcBaseServiceImpl implements IJdbcBaseService {

	@Autowired
	private JdbcBaseDao jdbcBaseDao;

	public List<HashMap<String, Object>> query(QueryVO vo, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> dataList=  jdbcBaseDao.query(vo,pageNo,pageSize);
		return dataList;
	}

	@Override
	public void add(DataVO vo) {
		jdbcBaseDao.add(vo);
	}

}
