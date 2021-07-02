package com.trkj.tsm.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.entity.Register;
import com.trkj.tsm.entity.Source;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

/**
 * student
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
@OpjournalAnnotation(message = "学员")
public class StudentVo{
    /**
     * 学员编号
     */
    private Integer studentId;

    /**
     * 班级编号
     */
    private Integer classesId;
    private Classes classes;


    /**
     * 生源渠道编号
     */
    private Integer sourceId;
    private Source source;

    /**
     * 咨询登记编号
     */
    private Integer registerId;
    private Register register;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 就读时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date studytime;

    /**
     * 入学备注
     */
    private String entrance;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系电话
     */
    private String studentPhone;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 照片地址
     */
    private String imgaddress;

    /**
     * 家长姓名
     */
    private String parentname;

    /**
     * 家长电话
     */
    private String parentphone;

    /**
     * 最后修改人
     */
    public String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * 删除人
     */
    public String deletename;

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
     * 已上课时
     */
    private Integer ysclasshour;

    private static final long serialVersionUID = 1L;
}