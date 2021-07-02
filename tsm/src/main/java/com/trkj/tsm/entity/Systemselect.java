package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * systemselect
 * @author
 */
@Data
public class Systemselect implements Serializable {
    /**
     * 制度允许查询编号
     */
    private Integer systemselectId;

    /**
     * 规章制度编号
     */
    private Integer systemId;

    /**
     * 允许查看用户编号
     */
    private Integer empId;

    /**
     * 阅读状态
     */
    private Integer readstate;

    /**
     * 阅读时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date readtime;

    private static final long serialVersionUID = 1L;
}