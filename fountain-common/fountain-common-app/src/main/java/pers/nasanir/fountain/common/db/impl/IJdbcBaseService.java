package pers.nasanir.fountain.common.db.impl;


import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;

import java.util.HashMap;
import java.util.List;

public interface IJdbcBaseService {
	List<HashMap<String, Object>> query(QueryVO vo, int pageNo, int pageSize);

	void add(DataVO vo);
}
