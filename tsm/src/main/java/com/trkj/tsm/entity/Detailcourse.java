package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * detailcourse
 * @author 
 */
@Data
public class Detailcourse implements Serializable {
    /**
     * 课程详情编号
     */
    private Integer detailcourseId;

    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 课程详细名称
     */
    private String detailcourseName;

    /**
     * 课程序列号
     */
    private Integer serial;

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