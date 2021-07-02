package com.trkj.tsm.controller;

import com.trkj.tsm.dao.SysUserRoleDao;
import com.trkj.tsm.entity.SysUserRole;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EmpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
public class Emp_RoleController {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @PostMapping("/insertuserrole")
    public AjaxResponse insertEmp(@RequestBody @Valid SysUserRole sysUserRole) {
        sysUserRoleDao.insertSelective(sysUserRole);
        return AjaxResponse.success("成功");
    }
}
