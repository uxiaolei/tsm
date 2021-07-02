package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * shift
 * @author 
 */
@Data
@OpjournalAnnotation(message = "转班")
public class Shift implements Serializable {
    /**
     * 编号
     */
    private Integer shiftId;

    /**
     * 课程详情Id
     */
    private Integer courserecorddetailsId;
    private Courserecorddetails courserecorddetails;
    /**
     * 原班级
     */
    private String oldclass;

    /**
     * 意向班级
     */
    private String newclass;

    /**
     * 转班时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date shiftTime;

    /**
     * 转班理由
     */
    private String shiftReason;

    /**
     * 转班办理人
     */
    public String shiftHandler;

    /**
     * 操作审批
     */
    private Integer approval;

    /**
     * 教务部审批人
     */
    public String jwAppname;

    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jwApptime;

    /**
     * 撤销审批人
     */
    public String jwDropnameapp;

    /**
     * 撤销审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jwDroptimeapp;

    /**
     * 删除人
     */
    public String deletename;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}