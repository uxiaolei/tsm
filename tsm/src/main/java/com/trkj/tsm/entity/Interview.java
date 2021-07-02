package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * interview
 * @author 
 */
@Data
@OpjournalAnnotation(message = "学员访谈")
public class Interview implements Serializable {
    /**
     * 访谈编号
     */
    private Integer interviewId;

    /**
     * 班级编号
     */
    private Classes classes;
    private Integer classesId;

    /**
     * 学员编号
     */
    private Student student;
    private Integer studentId;

    /**
     * 访谈时间
     */
    private Date interviewTime;

    /**
     * 访谈人
     */
    public String interviewname;

    /**
     * 访谈主题
     */
    private String theme;

    /**
     * 进展程度
     */
    private String progress;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    public String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}