package com.trkj.tsm.vo;

import com.trkj.tsm.entity.SysMenu;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private int id;
    private String username;
    private String password;
    private String token;
    private boolean isValidate;
    private List<SysMenu> menus;
}
