package top.newfoodie.common.api;

/**
 * @author: wangdarui
 * @date: 2020/8/1
 */
public class Paging {

    /**
     * 分页起始位置
     */
    private Integer offset;

    /**
     * 每一页的数量
     */
    private Integer limit;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 是否存在下一页
     */
    private Boolean hasMore;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
