package com.trkj.tsm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AdvancearrangeVo {
    /**
     * 排课编号
     */
    private Integer arrangeId;

    /**
     * 排课日期
     */
    private Date arrangeDate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否审核
     */
    private Integer isexamine;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 培训时段编号
     */
    private Integer periodId;
    private TrainingPeriodVo trainingPeriodVo;

    /**
     * 班级编号
     */
    private Integer classesId;
    private ClassesVo classesVo;
    /**
     * 教室编号
     */
    private Integer classroomId;
    private ClassroomVo classroomVo;
    /**
     * 教师编号
     */
    private Integer empId;
    private EmpVo empVo;

    private Integer CoursedetailsId;

}
