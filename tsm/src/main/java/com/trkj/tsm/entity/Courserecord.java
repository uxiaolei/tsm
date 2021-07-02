package com.trkj.tsm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * courserecord
 * @author 
 */
@Data
public class Courserecord implements Serializable {
    /**
     * 报课记录编号
     */
    private Integer courserecordId;

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
     * 应收金额
     */
    private BigDecimal receipts;

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