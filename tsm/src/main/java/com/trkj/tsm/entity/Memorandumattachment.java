package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * memorandumattachment
 * @author 
 */
@Data
public class Memorandumattachment implements Serializable {
    /**
     * 交接编号
     */
    private Integer memorandumattachmentId;

    /**
     * 咨询登记编号
     */
    private Register register;
    private Integer registerId;

    /**
     * 招生审核状态
     */
    private Integer zsisexamine;

    /**
     * 招生审核时间
     */
    private Date zsexaminetime;

    /**
     * 招生审核人员
     */
    private String zsexaminename;

    /**
     * 招生撤销审核时间
     */
    private Date zsrevoketime;

    /**
     * 招生撤销审核人员
     */
    private String zsrevokename;

    /**
     * 教务审核状态
     */
    private Integer jwisexamine;

    /**
     * 教务审核时间
     */
    private Date jwexaminetime;

    /**
     * 教务审核人
     */
    private String jwexaminename;

    /**
     * 教务审核撤销时间
     */
    private Date jwrevoketime;

    /**
     * 教务审核撤销人
     */
    private String jwrevokename;

    private static final long serialVersionUID = 1L;
}