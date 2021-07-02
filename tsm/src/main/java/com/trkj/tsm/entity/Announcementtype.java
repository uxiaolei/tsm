package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * announcementtype
 * @author
 */
@Data
@OpjournalAnnotation(message = "公告类型")
public class Announcementtype implements Serializable {
    /**
     * 公告类型名称
     */
    private Integer announcementtypeId;

    /**
     * 公告类型名称
     */
    private String announcementtypeName;

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

    private static final long serialVersionUID = 1L;
}