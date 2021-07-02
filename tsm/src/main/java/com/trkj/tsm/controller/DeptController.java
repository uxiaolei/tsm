package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.DeptService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.DeptVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("/selectAllDept")
    public List<DeptVo> selectAllDept(){
        return deptService.selectAllDept();
    }

    @GetMapping("/selectAllDeptPageInfo")
    public PageInfo<DeptVo> selectAllDept(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<DeptVo> deptPage = deptService.selectAllDept();
        PageInfo<DeptVo> deptPageInfo = new PageInfo<>(deptPage);
        return deptPageInfo;
    }

    @PostMapping("/insertDept")
    public DeptVo inserDept(@RequestBody DeptVo deptVo) {
        deptService.insertDept(deptVo);
        return deptVo;
    }

    @PutMapping("/updateDept")
    public DeptVo updateDept(@RequestBody DeptVo deptVo) {
        deptService.updateDept(deptVo);
        return deptVo;
    }

    @PutMapping("/deleteDept")
    public DeptVo deleteDept(@RequestBody DeptVo deptVo) {
        deptService.deleteDept(deptVo);
        return deptVo;
    }

    @PutMapping("/deleteDeptMany/{ids}")
    public AjaxResponse deleteDeptMany(@PathVariable("ids") String ids){
        deptService.deleteDeptMany(ids);
        return AjaxResponse.success();
    }

    @GetMapping("/selectDeptByName")
    public PageInfo<DeptVo> selectDeptByName(@RequestParam("what") String deptName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<DeptVo> deptPage = deptService.selectDeptByName(deptName);
        PageInfo<DeptVo> deptPageInfo = new PageInfo<>(deptPage);
        return deptPageInfo;
    }

    @GetMapping("/selectDeptBySortnumber")
    public PageInfo<DeptVo> selectDeptBySortnumber(@RequestParam("what") String deptSortnumber, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<DeptVo> deptPage = deptService.selectDeptBySortnumber(deptSortnumber);
        PageInfo<DeptVo> deptPageInfo = new PageInfo<>(deptPage);
        return deptPageInfo;
    }
}
