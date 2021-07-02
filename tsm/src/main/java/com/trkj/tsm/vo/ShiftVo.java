package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Courserecorddetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * shift
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "转班")
public class ShiftVo implements Serializable {
    /**
     * 编号
     */
    private Integer shiftId;

    /**
     * 课程详情Id
     */
    private Integer courserecorddetailsId;
    private CourserecorddetailsVo courserecorddetailsVo;
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

    private Integer classesId;

    private static final long serialVersionUID = 1L;
}