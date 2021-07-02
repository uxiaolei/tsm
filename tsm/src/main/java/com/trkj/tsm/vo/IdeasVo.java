package com.trkj.tsm.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.entity.Suggest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class IdeasVo {
    /**
     * 编号
     */
    private Integer ideasId;

    /**
     * 意见箱编号
     */
    @JsonIgnore
    private Suggest suggest;
    private Integer suggestId;

    /**
     * 发布人意见
     */
    @JsonIgnore
    private Emp emp;
    private Integer empId;

    /**
     * 意见标题
     */
    private String ideasTitle;

    /**
     * 意见内容
     */
    private String ideasName;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 回复人
     */
    private String reply;

    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revoverytime;

    /**
     * 回复内容
     */
    private String revoveryname;

    /**
     * 发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date timeofpublication;

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

    /**
     * 是否可查看
     */
    private Integer ideasLook;

    /**
     * 是否匿名
     */
    private Integer ideasAnonymous;

    private static final long serialVersionUID = 1L;
}