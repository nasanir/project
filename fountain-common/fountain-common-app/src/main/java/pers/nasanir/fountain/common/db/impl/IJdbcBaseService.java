package pers.nasanir.fountain.common.db.impl;


import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;

public interface IJdbcBaseService {
	 AbstractVO query(QueryVO vo);
}
