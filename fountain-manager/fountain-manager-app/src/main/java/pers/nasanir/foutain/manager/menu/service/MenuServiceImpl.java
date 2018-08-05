package pers.nasanir.foutain.manager.menu.service;

import org.springframework.stereotype.Service;
import pers.nasanir.fountain.common.common.entity.AbstractVO;
import pers.nasanir.foutain.manager.menu.itf.IMenuService;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Override
    public List<AbstractVO> getAllMenus() {


        return null;
    }
}
