package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * loginjournal
 * @author
 */
@Data
public class Loginjournal implements Serializable {
    /**
     * 登录日志编号
     */
    private Integer loginjournalId;

    /**
     * 职员编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 登入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date logintime;

    /**
     * 退出时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date exittime;

    private static final long serialVersionUID = 1L;
}