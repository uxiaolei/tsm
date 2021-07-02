package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * bookback
 * @author 
 */
@Data
public class Bookback implements Serializable {
    /**
     * 教材破损编号
     */
    private Integer bookbackId;

    /**
     * 破损处理人员
     */
    private Emp emp;
    private Integer empId;

    /**
     * 教材编号
     */
    private Book book;
    private Integer bookId;

    /**
     * 学员编号
     */
    private Student student;
    private Integer studentId;


    /**
     * 破损处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date storagetime;


    /**
     * 退回金额
     */
    private Integer BackSprice;


    /**
     * 退回数量
     */
    private Integer BackSl;





    /**
     * 破损原因描述
     */
    private String causeofdamage;

    /**
     * 审批
     */
    private Integer approval;

    /**
     * 审批人
     */
    private String appname;

    /**
     * 审批时间
     */
    private Date apptime;

    /**
     * 撤销审批人
     */
    private String revokeAppname;

    /**
     * 撤销审批时间
     */
    private Date revokeApptime;

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

    private Integer timelinessback;

    private static final long serialVersionUID = 1L;
}