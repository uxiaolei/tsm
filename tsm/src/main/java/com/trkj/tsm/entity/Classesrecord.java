package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * classesrecord
 * @author 
 */
@Data
@OpjournalAnnotation(message = "报课总表")
public class Classesrecord implements Serializable {
    /**
     * 报班记录编号
     */
    private Integer classesrecordId;

    /**
     * 学员编号
     */
    private Integer studentId;
    private Student student;
    /**
     * 职工编号
     */
    private Integer empId;
    private Emp emp;
    /**
     * 班级编号
     */
    private Integer classesId;
    private Classes classes;
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