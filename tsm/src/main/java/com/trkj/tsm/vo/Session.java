package com.trkj.tsm.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * session
 * @author 
 */
@Data
public class Session  {
    /**
     * 编号
     */
    private Integer sessionId;

    /**
     * 年届名称
     */
    private String sessionName;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 最后修改人
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

    private static final long serialVersionUID = 1L;
}