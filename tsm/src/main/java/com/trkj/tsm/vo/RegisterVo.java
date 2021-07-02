package com.trkj.tsm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import lombok.Data;

import java.util.Date;

/**
 * register
 * @author 
 */
@Data
@OpjournalAnnotation(message = "新增咨询登记")
public class RegisterVo {
    /**
     * 咨询登记编号
     */
    private Integer registerId;

    /**
     * 回访次数
     */
    private Integer total;


    /**
     * 生源渠道编号
     */
    /*从表实体类应该包含一个主表实体类的对象引用*/
    private SourceVo sourceVo;
    private Integer sourceId;

    /**
     * 课程编号
     */
    private CourseVo courseVo;
    private Integer courseId;

    /**
     * 课程详细编号
     */
    private DetailcourseVo detailcourseVo;
    private Integer detailcourseId;

    /**
     * 接待人
     */
    private EmpVo empVo;
    private Integer empId;

    /**
     * 咨询人联系方式
     */
    private String phone;

    /**
     * 咨询人
     */
    private String consultant;

    /**
     * 咨询人性别
     */
    private String sex;

    /**
     * 咨询内容
     */
    private String consultcontent;

    /**
     * 咨询状态
     */
    private Integer attentstate;

    /**
     * 新增咨询登记职工
     */
    public String addname;

    /**
     * 新增咨询登记当前时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 删除人员
     */
    public String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 最后修改人员
     */
    public String lastupdatename;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 缴费状态
     */
    private Integer paystate;

    private static final long serialVersionUID = 1L;
}