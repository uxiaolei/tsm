package com.trkj.tsm.vo;

import java.io.Serializable;

import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.entity.Course;
import com.trkj.tsm.entity.Courserecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * courserecorddetails
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class CourserecorddetailsVo implements Serializable {
    /**
     * 报课记录详情编号
     */
    private Integer courserecorddetailsId;

    /**
     * 报课记录总表编号
     */
    private Integer courserecordId;
    private CourserecordVo courserecordVo;
    /**
     * 课程编号
     */
    private Integer courseId;
    private CourseVo courseVo;

    /**
     * 班级编号
     */
    private Integer classesId;
    private ClassesVo classesVo;

    /**
     * 状态
     */
    private Integer learningstate;


    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}