package com.trkj.tsm.service;

import com.trkj.tsm.dao.SysRoleDao;
import com.trkj.tsm.dao.SysUserRoleDao;
import com.trkj.tsm.entity.SysUserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public SysUserRole add(SysUserRole sysUserRole) {
        sysUserRoleDao.insertSelective(sysUserRole);
        return sysUserRole;
    }
}
