package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;

/**
 * courserecord
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "报课总表")
public class CourserecordVo{
    /**
     * 报课记录编号
     */
    private Integer courserecordId;

    /**
     * 学员编号
     */
    private Integer studentId;
    private StudentVo studentVo;
    /**
     * 职工编号
     */
    private Integer empId;
    private EmpVo empVo;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

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
    /**
     * 应收金额
     */
    private BigDecimal receipts;

    private static final long serialVersionUID = 1L;
}