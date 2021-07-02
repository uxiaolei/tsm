package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Courserecorddetails;
import com.trkj.tsm.entity.Suspend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

/**
 * back
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "复课")
public class BackVo{
    /**
     * 复课编号
     */
    private Integer backId;

    /**
     * 课程详情Id
     */
    private CourserecorddetailsVo courserecorddetailsVo;
    private Integer courserecorddetailsId;

    /**
     * 班级已上课时
     */
    private String classalreadyon;

    /**
     * 缺课节数
     */
    private Integer absent;

    /**
     * 复课意向
     */
    private Integer intention;

    /**
     * 复课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date backTime;

    /**
     * 复课办理人
     */
    public String backHandler;

    /**
     * 复课审批
     */
    private Integer backApproval;

    /**
     * 复课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date backBapptime;

    /**
     * 撤销复课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revokeApptime;

    /**
     * 修改人
     */
    public String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

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


    private String studentNumber;

    private String courseName;
    private Integer courseId;

    private String classesName;
    private Integer classesId;
    private static final long serialVersionUID = 1L;
}