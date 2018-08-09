package cn.wh.util;

public class PageUtil {
    private int pageIndex; //当前页
    private int pageSize; //页大小
    private int pageCount; //总页数
    private int totalCount; //总记录数
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (totalCount>0){
            this.totalCount = totalCount;  //获取总记录数
            //总页数=（总记录数%页大小==0）？（总记录数/页大小）:（总记录数/页大小+1）;
            this.pageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    @Override
    public String toString() {
        return "PageUtil{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                '}';
    }

}
