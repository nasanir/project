package pers.nasanir.fountain.common.common.entity;

import java.util.List;

public class  ResultVO<T extends AbstractVO>{
    private String module;
    private String funcCode;
    private int pageNo;
    private int limit;
    private List<T> dataList;
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
