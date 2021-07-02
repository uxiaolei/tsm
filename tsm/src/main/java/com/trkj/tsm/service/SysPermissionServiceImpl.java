package com.trkj.tsm.service;

import com.trkj.tsm.dao.SysMenuDao;
import com.trkj.tsm.dao.SysRoleDao;
import com.trkj.tsm.entity.SysMenu;
import com.trkj.tsm.util.MenuUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysRoleDao roleDao;
    @Resource
    private SysMenuDao menuDao;
    @Override
    public List<SysMenu> getMenuByUname(String userName) {
        List<SysMenu> list=menuDao.findMenusByRoleCodes( this.getRoleCodesByUname(userName));
        return MenuUtil.assemberMenus(list);
    }
    private List<String> getRoleCodesByUname(String userName){
        return roleDao.findRoleByUserName(userName);
    }
}
