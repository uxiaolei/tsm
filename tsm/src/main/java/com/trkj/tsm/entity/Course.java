package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
@OpjournalAnnotation(message = "课程")
public class Course implements Serializable {
    /**
     * 编号
     */
    private Integer courseId;


    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程状态
     */
    private String courseState;

    /**
     * 课时量
     */
    private Integer classhours;

    /**
     * 课程费用
     */
    private BigDecimal courseMoney;

    /**
     * 课类编号
     */
    private Classtype classtype;
    private Integer classtypeId;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

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
     * 停报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stoptime;

    /**
     * 停报人
     */
    public String stopname;

    /**
     * 开报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date begintime;

    /**
     * 开报办理人
     */
    public String beginname;

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