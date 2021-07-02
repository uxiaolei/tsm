package com.trkj.tsm.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * opjournal
 * @author
 */
@Data
public class Opjournal implements Serializable {
    /**
     * 日志编号
     */
    private Integer opjournalId;

    /**
     * 操作人员
     */
    private String Operator;

    /**
     * 操作内容
     */
    private String opcontent;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date optiome;

    private static final long serialVersionUID = 1L;
}