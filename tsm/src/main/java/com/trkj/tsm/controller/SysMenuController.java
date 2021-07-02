package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.dao.SysMenuDao;
import com.trkj.tsm.dao.SysRoleMenuDao;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.entity.SysMenu;
import com.trkj.tsm.entity.SysUserRole;
import com.trkj.tsm.util.MenuUtil;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EmpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SysMenuController {
    @Resource
    private SysMenuDao sysMenuDao;

    @Resource
    private SysRoleMenuDao sysRoleMenuDao;


    @DeleteMapping("/delAuthorByroleid")
    public AjaxResponse delAuthorByroleid(@RequestParam("roleid") int roleid,@RequestParam("Authors")String SAuthors) {

        sysRoleMenuDao.deleteByPrimaryKey(roleid);
        String [] strs=SAuthors.split("&");
        List<Integer> Authors=new ArrayList<>();
        for(int i=0,len=strs.length;i<len;i++){
            String[] a=strs[i].split("=");
            Authors.add(Integer.valueOf(a[1]));
        }
        sysRoleMenuDao.insertSelectives(Authors,roleid);

        return AjaxResponse.success("成功修改角色"+roleid+"的权限");
    }

    @GetMapping("/selectMenuByroleid")
    public AjaxResponse selectMenuByroleid(@RequestParam("roleid") int roleid) {
       List<SysMenu> sysMenus= sysMenuDao.findMenusByRoleid(roleid);
        return AjaxResponse.success(sysMenus);
    }
    @GetMapping("/selectMenus")
    public AjaxResponse selectMenus() {
        List<SysMenu> sysMenus= sysMenuDao.findMenus();
        log.debug(sysMenus.toString());
        List<SysMenu> sysMenuList=MenuUtil.assemberMenus2(sysMenus);
        return AjaxResponse.success(sysMenuList);
    }


}
