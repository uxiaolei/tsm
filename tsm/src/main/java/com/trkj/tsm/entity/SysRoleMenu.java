package com.trkj.tsm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_role_menu
 * @author 
 */
@Data
public class SysRoleMenu implements Serializable {
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}