package com.trkj.tsm.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class RoleVo {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private String roleCode;
    private Integer sort;
    private Integer status;
    private Timestamp createTime;
    private List<MenuVo> menus;
}
