package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * announcement
 * @author
 */
@Data
@OpjournalAnnotation(message = "公告")
public class Announcement implements Serializable {
    /**
     * 公告编号
     */
    private Integer announcementId;

    /**
     * 公告类型
     */
    private Announcementtype announcementtype;
    private Integer announcementtypeId;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

    /**
     * 公告主题
     */
    private String announcementTheme;

    /**
     * 公告内容
     */
    private String announcementContent;

    /**
     * 公告状态
     */
    private Integer announcementState;

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
     * 最后修改人
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

    /**
     * 最后发布人
     */
    public String publishname;

    /**
     * 最后发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishtime;

    /**
     * 最后暂停人
     */
    public String suspenname;

    /**
     * 最后暂停时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspentime;

    private static final long serialVersionUID = 1L;
}