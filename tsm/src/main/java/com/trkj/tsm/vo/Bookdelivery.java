package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * bookdelivery
 * @author 
 */
@Data
public class Bookdelivery  {
    /**
     * 教材出库总编号
     */

    private Integer bookdeliveryId;

    /**
     * 学员编号
     */
    private StudentVo student;
    private Integer studentId;

    /**
     * 入库员职工编号
     */
    private EmpVo emp;
    private Integer empId;

    /**
     * 销售编号
     */
    private String salenumber;

    /**
     * 出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliverytime;

    /**
     * 总价格
     */
    private BigDecimal tota;

    /**
     * 缴费金额
     */
    private BigDecimal paymoney;

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