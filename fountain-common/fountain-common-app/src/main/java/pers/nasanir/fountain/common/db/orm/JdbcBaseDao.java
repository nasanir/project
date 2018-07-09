package pers.nasanir.fountain.common.db.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.nasanir.fountain.common.common.entity.AbstractVO;

import java.util.HashMap;

/**
 * 通用查询dao层
 * 
 * @author nasanir
 *
 */
@Repository("jdbcBaseDao")
public class JdbcBaseDao {
	@Autowired
	private CrudDaoImpl crudDao;

	public AbstractVO query(AbstractVO vo) {
		// TODO Auto-generated method stub
		HashMap<String, Object> valueMap = crudDao.query(vo);
		transFormData(valueMap, vo);
		return vo;
	}

	private AbstractVO transFormData(HashMap<String, Object> valueMap, AbstractVO vo) {
		if (valueMap != null) {
			for (String name : valueMap.keySet()) {
				if (valueMap.get(name).getClass().getName().equals("java.lang.Boolean")) {
					if ((boolean) valueMap.get(name)) {
						valueMap.put(name, 1);
					} else {
						valueMap.put(name, 0);
					}
				}
				vo.setValue(name, valueMap.get(name));
			}
		}
		return vo;
	}

}
