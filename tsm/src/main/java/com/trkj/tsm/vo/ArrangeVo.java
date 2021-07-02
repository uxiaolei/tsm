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

public class ArrangeVo {
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
     * 审核时间
     */
    private Date examinetime;

    /**
     * 审核人
     */
    public String examinename;

    /**
     * 撤销审核时间
     */
    private Date revoketime;

    /**
     * 撤销审核人
     */
    public String revokename;

    /**
     * 增加人
     */
    public String addname;

    /**
     * 增加日期
     */
    private Date addtime;

    /**
     * 最后修改人
     */
    public String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    public String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

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
    private ClassroomVo classRoomVo;
    /**
     * 教师编号
     */
    private Integer empId;
    private EmpVo empVo;
    /**
     * 课程详细编号
     */
    private Integer coursedetailsId;
    private CourseDetailsVo courseDetailsVo;

    private static final long serialVersionUID = 1L;
}
