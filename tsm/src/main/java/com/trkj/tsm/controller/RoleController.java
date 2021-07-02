package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.RoleService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class RoleController {
    @Resource
    private RoleService roleService;

    @GetMapping("/selectAllrole")
    public PageInfo<RoleVo> selectAllrole(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<RoleVo> roleVos=roleService.selAll();
        PageInfo<RoleVo> roleVoPageInfo = new PageInfo<>(roleVos);
        return roleVoPageInfo;
    }

    @GetMapping("/selAllmh")
    public PageInfo<RoleVo> selAllmh(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("rolename") String rolename){
        PageHelper.startPage(currentPage,pagesize);
        List<RoleVo> roleVos=roleService.selAllmh(rolename);
        PageInfo<RoleVo> roleVoPageInfo=new PageInfo<>(roleVos);
        return roleVoPageInfo;
    }

    @PostMapping("/insertrole")
    public AjaxResponse insertUnit(@RequestBody RoleVo roleVo){
        roleService.addRole(roleVo);
        return AjaxResponse.success("新增角色成功");
    }

    @PutMapping("/updRole")
    public AjaxResponse updRole(@RequestBody @Valid RoleVo roleVo){
        roleService.updRole(roleVo);
        return AjaxResponse.success("修改角色成功");
    }

    @GetMapping("/selectArole")
    public List<RoleVo> selectArole() {
        List<RoleVo> roleVos=roleService.selAll();
        return roleVos;
    }
    @GetMapping("/selrolebyempid")
    public List<RoleVo> selectArole(@RequestParam("empid") int empid) {
        List<RoleVo> roleVos=roleService.selrolebyempid(empid);
        return roleVos;
    }

}
