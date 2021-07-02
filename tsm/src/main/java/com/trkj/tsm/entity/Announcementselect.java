package com.trkj.tsm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * announcementselect
 * @author
 */
@Data
public class Announcementselect implements Serializable {
    /**
     * 公告允许查询编号
     */
    private Integer announcementselectId;

    /**
     * 公告编号
     */
    private Announcement an;
    private Integer announcementId;

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