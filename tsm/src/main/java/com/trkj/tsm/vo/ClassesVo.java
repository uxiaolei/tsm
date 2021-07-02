package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * classes
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "班级")

public class ClassesVo{


    private Integer manylessons;

    private Integer coursedetailsId;
    /**
     * 编号
     */
    private Integer classesId;

    /**
     * 课程编号
     */
    private CourseVo course;
    private Integer courseId;

    /**
     * 教员编号
     */
    private EmpVo emp;
    private Integer teacherId;

    /**
     * 班主任编号
     */
    private Integer empId;
    private EmpVo emp2;


    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 班级容纳人数
     */
    private int classesSize;

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
     * 培训最终结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastdate;

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