package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aa on 2017/8/8.
 */
//分页的每页内容可能不同，使用泛型
public class  PageBean<T> {
    private int page; //当前页
    private int totalRecord; //总记录数
    private int limit; //每一页的记录数
    private int totalPage;  //总页数=总记录数 /  每一页的记录数

    //一页的内容
    private List<T> list = new ArrayList<T>();

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", totalRecord=" + totalRecord +
                ", limit=" + limit +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {

        this.page = page;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPage() {

        return totalRecord % limit == 0 ? totalRecord / limit : totalRecord / limit + 1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
