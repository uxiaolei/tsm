package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * suspend
 * @author 
 */
@Data
public class Suspend implements Serializable {
    /**
     * 停课编号
     */
    private Integer suspendId;

    /**
     * 课程详情Id
     */
    private Courserecorddetails courserecorddetails;
    private Integer courserecorddetailsId;

    /**
     * 停课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspendTime;

    /**
     * 停课理由
     */
    private String suspendReason;

    /**
     * 停课办理人
     */
    private String suspendHandler;

    /**
     * 停课审批
     */
    private Integer suspendApproval;

    /**
     * 停课审批人
     */
    private String suspendSappname;

    /**
     * 停课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suspendSapptime;

    /**
     * 撤销停课审批人
     */
    private String revokeAppname;

    /**
     * 撤销停课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revokeTapptime;

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

    private static final long serialVersionUID = 1L;
}