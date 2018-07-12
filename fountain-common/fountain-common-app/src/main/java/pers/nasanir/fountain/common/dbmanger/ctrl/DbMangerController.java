package pers.nasanir.fountain.common.dbmanger.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.nasanir.fountain.common.dbmanger.itf.DbMangerService;

import java.io.IOException;

@RestController
public class DbMangerController {
    @Autowired
    DbMangerService dbMangerService;

    @RequestMapping(value = "/common/dbmanger/createsql",method = RequestMethod.GET)
    public String createSql() throws IOException {
        dbMangerService.createsql();
        return "";
    }
}
