package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * system
 * @author
 */
@Data
public class System implements Serializable {
    /**
     * 制度编号
     */
    private Integer systemId;

    /**
     * 制度类型编号
     */
    private Systemtype systemtype;
    private Integer systemtypeId;

    /**
     * 制度主题
     */
    private String systemTheme;

    /**
     * 发文单位
     */
    private Dept dept;
    private Integer deptId;

    /**
     * 制度内容
     */
    private String systemContent;

    /**
     * 制度状态
     */
    private Integer systemState;

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

    /**
     * 最后发布人
     */
    private String publishname;

    /**
     * 最后发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishtime;

    /**
     * 最后暂停人
     */
    private String suspendname;

    /**
     * 最后暂停时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspendtime;

    private static final long serialVersionUID = 1L;
}