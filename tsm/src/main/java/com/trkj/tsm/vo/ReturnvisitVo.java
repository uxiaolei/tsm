package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

import java.util.Date;

/**
 * returnvisit
 * @author 
 */
@Data
@OpjournalAnnotation(message = "新增回访记录")
public class ReturnvisitVo{
    /**
     * 回访编号
     */
    private Integer returnvisitId;
    /**
     * 回访次数
     */
    private Integer total;
    /**
     * 咨询登记编号
     */
    private RegisterVo registerVo;
    private Integer registerId;

    /**
     * 接待人
     */
    private EmpVo empVo;
    private Integer empId;

    /**
     * 回访方式
     */
    private String returnvisitmode;

    /**
     * 回访日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    public String addname;

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
    public String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    private static final long serialVersionUID = 1L;
}