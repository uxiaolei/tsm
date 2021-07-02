package com.trkj.tsm.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * studentoutstanding
 * @author 
 */
@Data
@OpjournalAnnotation(message = "学员欠费补缴")
public class StudentoutstandingVo {
    /**
     * 编号
     */
    private Integer outstandingId;

    /**
     * 报班缴费编号
     */
    private EntryfeesVo entryfeesVo;
    private Integer feesId;

    /**
     * 单据号
     */
    private String outstandingName;

    /**
     * 补缴日期
     */
    private Date outstandingDate;

    /**
     * 补缴金额
     */
    private BigDecimal alongmoney;

    /**
     * 累积欠费
     */
    private BigDecimal accumulateds;

    /**
     * 经办人
     */
    public String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    public String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 审批人
     */
    public String approvalname;

    /**
     * 审批时间
     */
    private Date approvaltime;

    /**
     * 撤销审批人
     */
    public String revokeappname;

    /**
     * 撤销审批时间
     */
    private Date revokeapptime;

    /**
     * 删除人
     */
    public String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;
    /**
     * 审核状态
     */
    private Integer approvalType;

    private static final long serialVersionUID = 1L;
}