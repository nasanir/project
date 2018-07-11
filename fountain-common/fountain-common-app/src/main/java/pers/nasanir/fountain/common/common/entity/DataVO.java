package pers.nasanir.fountain.common.common.entity;

public class DataVO extends BaseVO{
    private String module;
    private String function;
    private VOSet<AbstractVO> dataSet;
    private String action;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public VOSet<AbstractVO> getDataSet() {
        return dataSet;
    }

    public void setDataSet(VOSet<AbstractVO> dataSet) {
        this.dataSet = dataSet;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
