package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ideas
 * @author
 */
@Data
public class Ideas implements Serializable {
    /**
     * 编号
     */
    private Integer ideasId;

    /**
     * 意见箱编号
     */
    private Suggest suggest;
    private Integer suggestId;

    /**
     * 发布人意见
     */
    private Emp emp;
    private Integer empId;

    /**
     * 意见标题
     */
    private String ideasTitle;

    /**
     * 意见内容
     */
    private String ideasName;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 回复人
     */
    private String reply;

    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revoverytime;

    /**
     * 回复内容
     */
    private String revoveryname;

    /**
     * 发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date timeofpublication;

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
     * 是否可查看
     */
    private Integer ideasLook;

    /**
     * 是否匿名
     */
    private Integer ideasAnonymous;

    private static final long serialVersionUID = 1L;
}