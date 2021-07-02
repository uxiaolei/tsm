package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * bookstorage
 * @author 
 */
@Data
public class Bookstorage implements Serializable {
    /**
     * 教材入库编号
     */
    private Integer mbookstorageId;

    /**
     * 入库员职工编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 入库数量
     */
    private Integer storagecount;

    /**
     * 入库时间
     */
    private Date storagetime;

    /**
     * 教材编号
     */
    private Book book;

    private Integer bookId;

    /**
     * 总价
     */
    private BigDecimal totalprice;

    /**
     * 审批
     */
    private Integer approval;

    /**
     * 审批人
     */
    private String appname;

    /**
     * 审批时间
     */
    private Date apptime;

    /**
     * 撤销审批人
     */
    private String revokeAppname;

    /**
     * 撤销审批时间
     */
    private Date revokeApptime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}