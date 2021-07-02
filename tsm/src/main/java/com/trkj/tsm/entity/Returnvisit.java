package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * returnvisit
 * @author 
 */
@Data
public class Returnvisit implements Serializable {
    /**
     * 回访编号
     */
    private Integer returnvisitId;

    /*
    * 总回访次数
    * */
    private Integer findTotal;

    /**
     * 咨询登记编号
     */
    private Register register;
    private Integer registerId;

    /**
     * 接待人
     */
    private Emp emp;
    private Integer empId;

    /**
     * 回访方式
     */
    private String returnvisitmode;

    /**
     * 回访日期
     */
    private Date returnvisitdate;

    /**
     * 回访反馈
     */
    private String returnvisitback;

    /**
     * 回访内容
     */
    private String returncontent;

    /**
     * 新增职工
     */
    private String addname;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 删除人员
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    private static final long serialVersionUID = 1L;
}