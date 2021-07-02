package com.trkj.tsm.vo;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

import java.util.Date;

/**
 * source
 * @author 
 */
@Data//数据
@OpjournalAnnotation(message = "新增生源渠道")//通用操作日志生成（切面）
public class SourceVo{
    /**
     * 生源渠道编号
     */
    private Integer sourceId;

    /**
     * 生源渠道
     */
    private String sourceName;

    /**
     * 已有生源
     */
    private Integer already;

    /**
     * 潜在生源
     */
    private Integer potential;

    /**
     * 新增渠道职工
     */
    public String addchannelname;

    /**
     * 新增渠道时间
     */
    private Date addchanneltime;

    /**
     * 最后修改人员
     */
    public String lastupdatename;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 删除渠道人员
     */
    public String delchannelname;

    /**
     * 删除渠道时间
     */
    private Date delchanneltime;

    private static final long serialVersionUID = 1L;
}