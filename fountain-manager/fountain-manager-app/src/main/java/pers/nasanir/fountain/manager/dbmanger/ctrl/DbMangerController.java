package pers.nasanir.fountain.manager.dbmanger.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.nasanir.fountain.manager.dbmanger.itf.DbMangerService;

import java.io.IOException;
import java.util.List;

@RestController
public class DbMangerController {
    @Autowired
    DbMangerService dbMangerService;

    @RequestMapping(value = "/common/dbmanger/createsql",method = RequestMethod.GET)
    public List<String> createSql() throws IOException {
        return dbMangerService.createsql();
    }
}
