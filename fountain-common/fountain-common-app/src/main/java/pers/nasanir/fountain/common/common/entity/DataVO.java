package pers.nasanir.fountain.common.common.entity;

public class DataVO<T extends AbstractVO> extends BaseVO{
    private String module;
    private String function;
    private VOSet<T> dataSet;
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

    public VOSet<T> getDataSet() {
        return dataSet;
    }

    public void setDataSet(VOSet<T> dataSet) {
        this.dataSet = dataSet;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
