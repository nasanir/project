package pers.nasanir.foutain.manager.dbmanger.service;

import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.db.util.TableVoUtils;
import pers.nasanir.foutain.manager.dbmanger.itf.DbMangerService;
import pers.nasanir.fountain.common.sql.factroy.SqlFactroy;

import java.io.IOException;
import java.util.List;

@Service("dbMangerService")
public class DbMangerServiceImpl implements DbMangerService {

    @Override
    public List<String> createsql() throws IOException {
        return SqlFactroy.createSqlBuilder().getCreateSql(TableVoUtils.getTableVoClass());
    }
}
