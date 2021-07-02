package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.entity.Courserecorddetails;
import lombok.Data;

/**
 * dropout
 * @author 
 */
@Data
public class Dropout implements Serializable {
    /**
     * 编号
     */
    private Integer dropId;

    private Integer courserecorddetailsId;
    private Courserecorddetails courserecorddetails;

//    /**
//     * 学员编号
//     */
//    private Integer studentId;
//    private Student student;
//    /**
//     * 课程编号
//     */
//    private Integer courseId;
//    private Course course;
//    /**
//     * 班级编号
//     */
//    private Integer classesId;
//    private Classes classes;
//    /**
//     * 课程详细编号
//     */
//    private Integer detailcourseId;
//    private Detailcourse detailcourse;
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
    private String dropHandler;

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
    private String jwAppname;

    /**
     * 教务部审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jwApptime;

    /**
     * 撤销教务部审批人
     */
    private String jwDropnameapp;

    /**
     * 撤销教务部审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date jwDroptimeapp;

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

    private static final long serialVersionUID = 1L;
}