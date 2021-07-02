package com.trkj.tsm.vo;

import java.io.Serializable;
import java.util.Date;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * trainingperiod
 * @author 
 */
@Data
@OpjournalAnnotation(message = "课段")
public class TrainingPeriodVo implements Serializable {
    /**
     * 编号
     */
    private Integer periodId;

    /**
     * 培训时段
     */
    private String period;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    public  String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    public String deletename;

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