package pers.nasanir.fountain.common.db.impl;


import pers.nasanir.fountain.common.common.entity.AbstractVO;

public interface IJdbcBaseService {
	 AbstractVO query(AbstractVO vo);
}
