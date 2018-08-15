package pers.nasanir.fountain.common.db.impl;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.fountain.common.common.entity.DataVO;
import pers.nasanir.fountain.common.common.entity.QueryVO;
import pers.nasanir.fountain.common.db.provider.BaseProvider;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CrudDao {
    @SelectProvider(type = BaseProvider.class, method = "query")
    public List<HashMap<String, Object>> query(QueryVO vo);

    @InsertProvider(type = BaseProvider.class,method ="add")
    public void add(DataVO vo);
}
