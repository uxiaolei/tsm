package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.entity.Emp;
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
public class LoginjournalVo implements Serializable {
    /**
     * 登录日志编号
     */
    private Integer loginjournalId;

    /**
     * 职员编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 登入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date logintime;

    /**
     * 退出时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date exittime;
}