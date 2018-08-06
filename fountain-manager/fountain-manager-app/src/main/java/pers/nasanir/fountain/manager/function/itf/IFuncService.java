package pers.nasanir.fountain.manager.function.itf;

import pers.nasanir.fountain.common.common.entity.AbstractVO;

import java.util.List;

public interface IFuncService {
    public AbstractVO add(String module,String function);

    public AbstractVO save(String module,String function,AbstractVO vo);

    public AbstractVO edit(String module,String function);

    public AbstractVO delete(String module,String function,AbstractVO vo);

    public List<AbstractVO> showList(String module,String function,AbstractVO vo);

    public AbstractVO show(String module,String function,AbstractVO vo);
}
