package pers.nasanir.fountain.common.db.orm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.db.provider.BaseProvider;

import java.util.HashMap;

/**
 * 通用查询接口
 * @author nasanir
 *
 */
@Mapper
public interface CrudDaoImpl {

	@SelectProvider(type = BaseProvider.class, method = "query")
	public HashMap<String, Object> query(AbstractVO vo);
}
