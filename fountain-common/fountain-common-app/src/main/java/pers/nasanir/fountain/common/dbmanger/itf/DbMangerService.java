package pers.nasanir.fountain.common.dbmanger.itf;

import java.io.IOException;
import java.util.List;

public interface DbMangerService {
    public List<String> createsql() throws IOException;
}
