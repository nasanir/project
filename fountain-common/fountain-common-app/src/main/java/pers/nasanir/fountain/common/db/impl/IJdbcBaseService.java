package pers.nasanir.fountain.common.db.impl;


import com.github.pagehelper.PageInfo;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;

import java.util.HashMap;
import java.util.List;

public interface IJdbcBaseService {
	List query(QueryVO vo);

	void add(DataVO vo);
}
