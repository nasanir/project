package pers.nasanir.fountain.manager.function.action;

import org.springframework.beans.factory.annotation.Autowired;
import pers.nasanir.fountain.common.common.entity.ResultVO;
import pers.nasanir.fountain.manager.function.itf.IAction;
import pers.nasanir.fountain.manager.function.mapper.FuncVOMapper;

public class BaseAction implements IAction {
    @Autowired
    FuncVOMapper funcVOMapper;

    @Override
    public ResultVO add() {
        return null;
    }

    @Override
    public ResultVO save() {
        return null;
    }

    @Override
    public ResultVO delete() {
        return null;
    }

    @Override
    public ResultVO showList() {
        return null;
    }

    @Override
    public ResultVO showCard() {
        return null;
    }

    private
}
