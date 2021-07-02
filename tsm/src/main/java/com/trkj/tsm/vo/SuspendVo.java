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
import java.util.Date;

/**
 * suspend
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "停课")
public class SuspendVo{
    /**
     * 停课编号
     */
    private Integer suspendId;

    /**
     * 课程详情Id
     */
    private CourserecorddetailsVo courserecorddetailsVo;
    private Integer courserecorddetailsId;

    /**
     * 停课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspendTime;

    /**
     * 停课理由
     */
    private String suspendReason;

    /**
     * 停课办理人
     */
    public String suspendHandler;

    /**
     * 停课审批
     */
    private Integer suspendApproval;

    /**
     * 停课审批人
     */
    public String suspendSappname;

    /**
     * 停课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspendSapptime;

    /**
     * 撤销停课审批人
     */
    public String revokeAppname;

    /**
     * 撤销停课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revokeTapptime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private String studentNumber;

    private String courseName;
    private Integer courseId;

    private String classesName;
    private Integer classesId;

    private static final long serialVersionUID = 1L;
}