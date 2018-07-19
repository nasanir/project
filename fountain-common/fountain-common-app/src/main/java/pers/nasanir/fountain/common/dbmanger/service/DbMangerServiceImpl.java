package pers.nasanir.fountain.common.dbmanger.service;

import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.db.util.TableVoUtils;
import pers.nasanir.fountain.common.dbmanger.itf.DbMangerService;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.reflect.ClassUtils;
import pers.nasanir.fountain.common.sql.factroy.SqlFactroy;
import pers.nasanir.fountain.common.sql.service.MysqlSqlBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

@Service("dbMangerService")
public class DbMangerServiceImpl implements DbMangerService {

    @Override
    public String createsql() throws IOException {
        SqlFactroy.createSqlBuilder().getCreateSql(TableVoUtils.getTableVoClass());
        return null;
    }
}
