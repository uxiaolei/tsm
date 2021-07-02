package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

/**
 * back
 * @author 
 */
@Data
@OpjournalAnnotation(message = "复课")
public class Back implements Serializable {
    /**
     * 复课编号
     */
    private Integer backId;

    /**
     * 课程详情Id
     */
    private Courserecorddetails courserecorddetails;
    private Integer courserecorddetailsId;

    /**
     * 班级已上课时
     */
    private String classalreadyon;

    /**
     * 缺课节数
     */
    private Integer absent;

    /**
     * 复课意向
     */
    private Integer intention;

    /**
     * 复课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date backTime;

    /**
     * 复课办理人
     */
    public String backHandler;

    /**
     * 复课审批
     */
    private Integer backApproval;

    /**
     * 复课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date backBapptime;

    /**
     * 撤销复课审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revokeApptime;

    /**
     * 修改人
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