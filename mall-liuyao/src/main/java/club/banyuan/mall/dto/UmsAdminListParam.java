package club.banyuan.mall.dto;

public class UmsAdminListParam {
    private String keyword;
    private Integer pageSize;
    private Integer pageNum;

    public UmsAdminListParam(String keyword, Integer pageSize, Integer pageNum) {
        this.keyword = keyword;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
