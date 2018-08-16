package pers.nasanir.fountain.common.sql.entity;

public class PageInfo {
    private int limit=0;
    private int pageTotal=-1;
    private int pageNo;

    public PageInfo(int limit,int pageNo){
        this.limit=limit;
        this.pageNo=pageNo;
    }

    public PageInfo(int limit, int pageNo, int pageTotal){
        this.limit=limit;
        this.pageNo=pageNo;
        this.pageTotal=pageTotal;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNumTotal(){
        if(pageTotal%limit!=0){
            return pageTotal/limit+1;
        }else{
            return pageTotal/limit;
        }
    }

    public int getOffset(){
        return (pageNo-1)*limit;
    }

}
