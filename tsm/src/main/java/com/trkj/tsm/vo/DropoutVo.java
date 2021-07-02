package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.entity.Course;
import com.trkj.tsm.entity.Detailcourse;
import com.trkj.tsm.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

/**
 * dropout
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "退学")
public class DropoutVo{
    /**
     * 编号
     */
    private Integer dropId;

    private Integer courserecorddetailsId;
    private CourserecorddetailsVo courserecorddetailsVo;

    /**
     * 退学时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dropRime;

    /**
     * 退学理由
     */
    private String dropReason;

    /**
     * 退学办理人
     */
    public String dropHandler;

    /**
     * 是否支付
     */
    private Integer ispay;

    /**
     * 教务部审批
     */
    private Integer jwApproval;

    /**
     * 教务部审批人
     */
    public String jwAppname;

    /**
     * 教务部审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jwApptime;

    /**
     * 撤销教务部审批人
     */
    public String jwDropnameapp;

    /**
     * 撤销教务部审批时间
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

    private String studentNumber;

    private String courseName;
    private Integer courseId;

    private String classesName;
    private Integer classesId;

    private static final long serialVersionUID = 1L;
}