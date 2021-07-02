package com.trkj.tsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程详细表(CourseDetails)实体类
 *
 * @author makejava
 * @since 2021-06-02 11:02:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course,classes")
public class CourseDetails implements Serializable {
    /**
     * 课程详细编号
     */
    private Integer coursedetailsId;
    /**
     * 课程详细名称
     */
    private String coursedetailsName;
    /**
     * 课程序列号
     */
    private Integer coursesequence;
    /**
     * 增加人
     */
    private String addname;
    /**
     * 增加时间
     */
    private Date addtime;
    /**
     * 最后修改人
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
     * 时效性
     */
    private Integer timeliness;
    /**
     * 课程编号
     */
    private Integer courseId;

    private Course course;
    private Classes classes;
    private static final long serialVersionUID = 1L;
}
