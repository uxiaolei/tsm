package com.trkj.tsm.vo;

import java.io.Serializable;
import java.util.Date;

import com.trkj.tsm.entity.Dept;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * emp
 * @author 
 */
@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class EmpVo  {
    /**
     * 职工编号
     */
    private Integer empId;

    /**
     * 部门编号
     */
    private Integer deptId;
    private Dept dept;

    /**
     * 工号
     */
    private String jobnumber;

    /**
     * 职工真实名称
     */
    private String empName;

    /**
     * 职工性别
     */
    private String empSex;

    /**
     * 职工电话
     */
    private String empPhone;

    /**
     * 电子邮件
     */
    private String eMail;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 教育水平
     */
    private String education;

    /**
     * 毕业学校
     */
    private String graduate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 最后修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 离职办理人
     */
    private String leavename;

    /**
     * 离职办理时间
     */
    private Date leavetime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 限制登录状态
     */
    private Boolean enabled;

    /**
     * 账户是否没过期
     */
    private Boolean accountNonExpired;

    /**
     * 是否没被锁定
     */
    private Boolean accountNonLocked;

    /**
     * 密码是否没有过期
     */
    private Boolean credentialsNonExpired;
}