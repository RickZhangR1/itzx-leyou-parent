package itzx.leyou.common.pojo;

import java.util.List;

/**
 * itzx.leyou.common.pojo
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/21 18:00
 */
public class PageResult<T> {
//    总记录数
    private Long total;
//    总页数
    private Integer totalPage;
//    记录
    private List<T> items;

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
