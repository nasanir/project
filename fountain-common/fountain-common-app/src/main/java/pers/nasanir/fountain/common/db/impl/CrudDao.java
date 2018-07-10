package pers.nasanir.fountain.common.db.impl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.db.provider.BaseProvider;

import java.util.HashMap;

@Mapper
public interface CrudDao {
    @SelectProvider(type = BaseProvider.class, method = "query")
    public  HashMap<String, Object> query(AbstractVO vo);
}
