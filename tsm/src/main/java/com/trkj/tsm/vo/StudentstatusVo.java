package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * studentstatus
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class StudentstatusVo{
    /**
     * 学员状态编号
     */
    private Integer studentstatusId;

    /**
     * 学员编号
     */
    private Integer studentId;
    private StudentVo studentVo;
    /**
     * 停课编号
     */
    private Integer suspendeId;
    private SuspendVo suspendVo;
    /**
     * 班级编号
     */
    private Integer classesId;
    private ClassesVo classesVo;
    /**
     * 课程编号
     */
    private Integer courseId;
    private CourseVo courseVo;
    /**
     * 报班时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date siguptime;

    /**
     * 学员状态
     */
    private Integer status;

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