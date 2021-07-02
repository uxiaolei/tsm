package com.trkj.tsm.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * storageexpenditure
 * @author 
 */
@Data
public class StorageexpenditureVo {
    /**
     * 编号
     */
    private Integer storageexpenditureId;

    /**
     * 教材入库编号
     */
    private Bookstorage bookstorage;
    private Integer mbookstorageId;

    /**
     * 单据号
     */
    private String refundName;

    /**
     * 收支日期
     */
    private Date refundDate;

    /**
     * 收支明细
     */
    private String refundDetails;

    /**
     * 已入数量
     */
    private Integer refundCount;

    /**
     * 收支总额
     */
    private BigDecimal totalmoney;

    /**
     * 现金金额
     */
    private BigDecimal usecash;

    /**
     * 经办人
     */
    private String addname;

    /**
     * 经办时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 审批
     */
    private Integer approval;

    /**
     * 审批人
     */
    private String appname;

    /**
     * 审批时间
     */
    private Date apptime;

    /**
     * 撤销审批人
     */
    private String revokeAppname;

    /**
     * 撤销审批时间
     */
    private Date revokeApptime;

    private static final long serialVersionUID = 1L;
}