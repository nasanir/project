package pers.nasanir.fountain.common.common.itf;

import pers.nasanir.fountain.common.common.entity.ResultVO;

public interface IAction {
    public ResultVO add();

    public ResultVO save();

    public ResultVO delete();

    public ResultVO showList();

    public ResultVO showCard();
}
