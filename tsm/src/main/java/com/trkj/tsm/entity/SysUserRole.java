package com.trkj.tsm.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * sys_user_role
 * @author 
 */
@Data
public class SysUserRole implements Serializable {
    private Integer id;

    /**
     * 角色自增id
     */
    private Integer roleId;

    /**
     * 用户自增id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}