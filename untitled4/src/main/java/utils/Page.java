package utils;

import lombok.Data;

@Data
/**
 * 分页工具类
 */
public class Page {
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 总条数
     */
    private int totalCount;
    /**
     * 当前页起始记录数
     */
    private int startCount;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示的条数
     */
    private int pageSize;
}
