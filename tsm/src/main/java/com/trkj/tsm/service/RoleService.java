package com.trkj.tsm.service;

import com.trkj.tsm.vo.RoleVo;

import java.util.List;

public interface RoleService {
    List<RoleVo> selAll();
    RoleVo addRole(RoleVo roleVo);
    List<RoleVo> selrolebyempid(int empid);
    int updRole(RoleVo roleVo);//修改
    List<RoleVo> selAllmh(String rolename);//模糊查询
}
