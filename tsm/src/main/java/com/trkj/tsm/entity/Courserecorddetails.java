package com.trkj.tsm.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * courserecorddetails
 * @author 
 */
@Data
public class Courserecorddetails implements Serializable {
    /**
     * 报课记录详情编号
     */
    private Integer courserecorddetailsId;

    /**
     * 报课记录总表编号
     */
    private Integer courserecordId;
    private Courserecord courserecord;

    /**
     * 课程编号
     */
    private Integer courseId;
    private Course course;

    /**
     * 班级编号
      */
    private Integer classesId;
    private Classes classes;

    /**
     * 状态
     */
    private Integer learningstate;


    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}