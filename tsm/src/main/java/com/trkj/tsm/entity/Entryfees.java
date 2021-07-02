package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * entryfees
 * @author 
 */
@Data
@OpjournalAnnotation(message = "报课补缴管理")
public class Entryfees implements Serializable {
    /**
     * 编号
     */
    private Integer feesId;

    /**
     * 咨询登记编号
     */
    private Register register;
    private Integer registerId;

    /**
     * 课程编号
     */
    private Course course;
    private Integer courseId;

    /**
     * 应收金额
     */
    private BigDecimal feesReceivable;

    /**
     * 单据号
     */
    private String feesName;

    /**
     * 缴费方式
     */
    private Integer feesType;

    /**
     * 预交金额
     */
    private BigDecimal feesAdvance;

    /**
     * 剩余学费
     */
    private BigDecimal accumulated;


    /**
     * 实收金额
     */
    private BigDecimal receipts;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 缴费状态
     */
    private Integer feesState;

    /**
     * 财务审批人
     */
    private String approvalname;

    /**
     * 财务审批时间
     */
    private Date approvaltime;

    /**
     * 撤销审批人
     */
    private String revokeappname;

    /**
     * 撤销审批时间
     */
    private Date revokeapptime;

    private static final long serialVersionUID = 1L;
}