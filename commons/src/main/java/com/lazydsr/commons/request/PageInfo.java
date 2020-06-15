package com.lazydsr.commons.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * PageInfo
 *
 * @author: daisenrong
 * @since: 2020/6/15 10:45 下午
 */
@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageInfo implements Serializable {

    public static final Integer PAGE_SIZE = 20;
    /**
     * 页码，从1开始
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总数
     */
    private Long total;
    /**
     * 起始行
     */
    private Integer startRow;
    /**
     * 末行
     */
    private Integer endRow;
    /**
     * 总页数
     */
    private Integer pages;

    public PageInfo() {
        this(null, null);
    }

    public PageInfo(Integer pageNum, Integer pageSize) {
        this(pageNum, pageSize, null);
    }

    public PageInfo(Integer pageNum, Integer pageSize, Long total) {
        this(pageNum, pageSize, total, null, null);
    }

    /**
     * dont calculate endRow,startRow
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param startRow startRow
     * @param endRow endRow
     */
    public PageInfo(Integer pageNum, Integer pageSize, Long total, Integer startRow, Integer endRow) {
        this(pageNum, pageSize, total, startRow, endRow, null);
    }

    public PageInfo(Integer pageNum, Integer pageSize, Long total, Integer startRow, Integer endRow, Integer pages) {
        this.pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;
        this.pageSize = (pageSize == null || pageSize < 1) ? PAGE_SIZE : pageSize;
        this.startRow = startRow;
        this.endRow = endRow;
        this.total = total;
        this.pages = pages;

        calculateStartAndEndRow();
    }

    /**
     * calculate startRow endRow Only if the parameters are correct
     */
    private void calculateStartAndEndRow() {
        if (pageNum != null && pageNum > 0 && pageSize != null && pageSize > 0) {
            this.startRow = (this.pageNum - 1) * this.pageSize;
            this.endRow = this.startRow + this.pageSize;
        }

        if (total != null && total > 0 && pageSize != null && pageSize > 0) {
            this.pages = (int)Math.ceil(total * 1.0 / pageSize);
        }

    }

    public void setpageNum(Integer pageNum) {
        this.pageNum = (pageNum == null || pageNum < 1) ? 1 : pageNum;
        calculateStartAndEndRow();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = (pageSize == null || pageSize < 1) ? PAGE_SIZE : pageSize;
        calculateStartAndEndRow();
    }

    public void setTotal(Long total) {
        this.total = (total == null || total < 0) ? 0 : total;
        calculateStartAndEndRow();
    }

}
