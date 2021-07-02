package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * refund
 * @author 
 */
@Data
@OpjournalAnnotation(message = "新增退费补缴")
public class Refund implements Serializable {
    /**
     * 退费编号
     */
    private Integer refundId;

    /**
     * 退学编号
     */
    private Dropout dropout;
    private Integer dropId;

    /**
     * 复课编号
     */
    private Back back;
    private Integer backId;

    /**
     * 停课编号
     */
    private Suspend suspend;
    private Integer suspendId;

    /**
     * 班级编号
     */
    private Classes classes;
    private Integer classesId;

    /**
     * 课程编号
     */
    private Course course;
    private Integer courseId;

    /**
     * 课程详细编号
     */
    private Detailcourse detailcourse;
    private Integer detailcourseId;

    /**
     * 退费类型
     */
    private String refundtype;

    /**
     * 回退金额
     */
    private BigDecimal dropMoney;

    /**
     * 回退金额审批
     */
    private Integer cwApproval;

    /**
     * 回退金额审人
     */
    private String cwAppname;

    /**
     * 回退金额审批时间
     */
    private Date cwApptime;

    /**
     * 回退金额撤销审批时间
     */
    private String cwDropappname;

    /**
     * 回退金额撤销审批时间
     */
    private Date cwDropapptime;

    /**
     * 退费办理人
     */
    public String addname;

    /**
     * 增加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

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

    private static final long serialVersionUID = 1L;
}