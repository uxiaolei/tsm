package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * arrange
 * @author 
 */
@Data
public class Arrange implements Serializable {
    /**
     * 排课编号
     */
    private Integer arrangeId;

    /**
     * 时段编号
     */
    private Integer periodId;

    /**
     * 班级编号
     */
    private Integer classesId;

    /**
     * 教室编号
     */
    private Integer classroomId;

    /**
     * 教室编号
     */
    private Integer teacherId;

    /**
     * 课程详细编号
     */
    private Integer detailcourseId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    private Date addtime;

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
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}