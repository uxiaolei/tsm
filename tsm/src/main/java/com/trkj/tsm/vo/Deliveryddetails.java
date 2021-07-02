package com.trkj.tsm.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * deliveryddetails
 * @author 
 */
@Data
public class Deliveryddetails  {
    /**
     * 教材出库编号
     */
    private Integer deliveryddetailsId;

    /**
     * 学员编号
     */
    private StudentVo student;
    private Integer studentId;

    /**
     * 职工编号
     */
    private EmpVo emp;
    private Integer empId;

    /**
     * 教材出库总编号
     */
    private com.trkj.tsm.vo.Bookdelivery bookdelivery;
    private Integer bookdeliveryId;

    /**
     * 教材编号
     */
    private Book book;
    private Integer bookId;

    /**
     * 出库数量
     */
    private Integer deliverycount;

    /**
     * 应收金额
     */
    private BigDecimal receivablemoney;


    private Integer timelinessdel;

    private static final long serialVersionUID = 1L;
}