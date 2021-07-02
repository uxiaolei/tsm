package com.trkj.tsm.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * register
 * @author 
 */
@Data
public class Register implements Serializable {
    /**
     * 咨询登记编号
     */
    private Integer registerId;

    /**
     * 生源渠道编号
     */
    private Source source;
    private Integer sourceId;

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
     * 接待人
     */
    private Emp emp;
    private Integer empId;

    /**
     * 咨询人联系方式
     */
    private String phone;

    /**
     * 咨询人
     */
    private String consultant;

    /**
     * 咨询人性别
     */
    private String sex;

    /**
     * 咨询内容
     */
    private String consultcontent;

    /**
     * 咨询状态
     */
    private Integer attentstate;

    /**
     * 新增咨询登记职工
     */
    private String addname;

    /**
     * 新增咨询登记当前时间
     */
    private Date addtime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 删除人员
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 最后修改人员
     */
    private String lastupdatename;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 缴费状态
     */
    private Integer paystate;

    private Integer total;

    private static final long serialVersionUID = 1L;
}