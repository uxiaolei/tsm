package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * studentstatus
 * @author 
 */
@Data
public class Studentstatus implements Serializable {
    /**
     * 学员状态编号
     */
    private Integer studentstatusId;

    /**
     * 学员编号
     */
    private Integer studentId;
    private Student student;
    /**
     * 停课编号
     */
    private Integer suspendeId;
    private Suspend suspend;
    /**
     * 班级编号
     */
    private Integer classesId;
    private Classes classes;
    /**
     * 课程编号
     */
    private Integer courseId;
    private Course course;
    /**
     * 报班时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date siguptime;

    /**
     * 学员状态
     */
    private Integer status;

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