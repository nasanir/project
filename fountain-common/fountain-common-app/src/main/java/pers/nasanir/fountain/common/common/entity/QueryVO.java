package pers.nasanir.fountain.common.common.entity;

import pers.nasanir.fountain.common.sql.entity.PageInfo;

public class QueryVO extends BaseVO {

    private String funcCode;
    private String where;
    private String groupBy;
    private String orderBy;
    private Boolean funcWhereVaild = true;
    private String sql;
    private PageInfo pageInfo;

    public PageInfo createPageInfo(int limit,int pageNo){
        pageInfo=new PageInfo(limit,pageNo);
        return pageInfo;
    }

    public PageInfo createPageInfo(int limit,int pageNo,int pageTotal){
        pageInfo=new PageInfo(limit,pageNo,pageTotal);
        return pageInfo;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Boolean getFuncWhereVaild() {
        return funcWhereVaild;
    }

    public void setFuncWhereVaild(Boolean funcWhereVaild) {
        this.funcWhereVaild = funcWhereVaild;
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
