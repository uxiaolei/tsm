package com.trkj.tsm.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * emp
 * @author 
 */
@Data
public class Emp implements UserDetails{
    //@JsonCreator
    public Emp(){

    }
    /**
     * 职工编号
     */
    private Integer empId;

    /**
     * 部门编号
     */
    private Integer deptId;
    private Dept    dept;

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

    private static final long serialVersionUID = 1L;

    Collection<? extends GrantedAuthority> authorities;  //用户的权限集合


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}