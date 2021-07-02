package com.trkj.tsm.service;

import com.trkj.tsm.entity.SysMenu;

import java.util.List;

public interface SysPermissionService {
    public List<SysMenu> getMenuByUname(String userName);
}
