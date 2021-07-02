package com.trkj.tsm.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * interview
 * @author 
 */
@Data
public class InterviewVo {
    /**
     * 访谈编号
     */
    private Integer interviewId;

    /**
     * 班级编号
     */
    private ClassesVo classesVo;
    private Integer classesId;

    /**
     * 学员编号
     */
    private StudentVo studentVo;
    private Integer studentId;

    /**
     * 访谈时间
     */
    private Date interviewTime;

    /**
     * 访谈人
     */
    private String interviewname;

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
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 增加人
     */
    private String addname;

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