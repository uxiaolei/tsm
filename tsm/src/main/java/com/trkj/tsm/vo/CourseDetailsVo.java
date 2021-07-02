package com.trkj.tsm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "courseVo,classesVo")
public class CourseDetailsVo {
    /**
     * 课程详细编号
     */
    private Integer coursedetailsId;
    /**
     * 课程详细名称
     */
    private String coursedetailsName;
    /**
     * 课程序列号
     */
    private Integer coursesequence;
    /**
     * 增加人
     */
    public String addname;
    /**
     * 增加时间
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
     * 课程编号
     */
    private Integer courseId;

    private CourseVo courseVo;
    private ClassesVo classesVo;
    private static final long serialVersionUID = 1L;
}
