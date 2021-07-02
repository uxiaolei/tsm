package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class SystemselectVo implements Serializable {
    /**
     * 制度允许查询编号
     */
    private Integer systemselectId;

    /**
     * 规章制度编号
     */
    private Integer systemId;

    /**
     * 允许查看用户编号
     */
    private Integer empId;

    /**
     * 阅读状态
     */
    private Integer readstate;

    /**
     * 阅读时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date readtime;
}