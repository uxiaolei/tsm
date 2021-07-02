package com.trkj.tsm.service;

import com.trkj.tsm.dao.SysRoleDao;
import com.trkj.tsm.entity.SysRole;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;

import java.util.List;
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    @Resource
    private SysRoleDao roleDao;

    @Override
    public List<RoleVo> selAll() {
        return roleDao.selAll();
    }

    @Override
    public List<RoleVo> selAllmh(String rolename) {
        return roleDao.selAllmh(rolename);
    }

    @Override
    public RoleVo addRole(RoleVo roleVo) {
        SysRole role=new SysRole();
        BeanCopyUtil.copyProperties(roleVo,role);
        role.setStatus(0);
        roleDao.insertSelective(role);
        return roleVo;
    }

    @Override
    public List<RoleVo> selrolebyempid(int empid) {
        return roleDao.selrolebyempid(empid);
    }

    @Override
    public int updRole(RoleVo roleVo) {
        SysRole role=new SysRole();
        BeanCopyUtil.copyProperties(roleVo,role);
        return roleDao.updateByPrimaryKeySelective(role);
    }

}
