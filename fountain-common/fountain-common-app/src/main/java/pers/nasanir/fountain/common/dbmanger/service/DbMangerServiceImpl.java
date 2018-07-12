package pers.nasanir.fountain.common.dbmanger.service;

import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.dbmanger.itf.DbMangerService;
import pers.nasanir.fountain.common.reflect.ClassUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@Service("dbMangerService")
public class DbMangerServiceImpl implements DbMangerService {
    @Override
    public String createsql() throws IOException {
        ClassUtils.getClassSet();
        return null;
    }
}
