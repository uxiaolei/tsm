package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * classes
 * @author 
 */
@Data
@OpjournalAnnotation(message = "班级")
public class Classes implements Serializable {

    private Integer manylessons;

    private Integer coursedetailsId;
    /**
     * 编号
     */
    private Integer classesId;

    /**
     * 课程编号
     */
    private Course course;
    private Integer courseId;

    /**
     * 教员编号
     */
    private Emp emp;
    private Integer teacherId;

    /**
     * 班主任编号
     */
    private Emp emp2;
    private Integer empId;

    /**
     * 课程详情编号
     */
    private Detailcourse detailcourse;
    private Integer detailcourseId;

    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 开班状态
     */
    private Integer classesOpen;

    /**
     * 培训开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date starteddate;

    /**
     * 培训计划结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    /**
     * 班级容纳人数
     */
    private int classesSize;

    /**
     * 培训最终结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastdate;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

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

    private static final long serialVersionUID = 1L;
}