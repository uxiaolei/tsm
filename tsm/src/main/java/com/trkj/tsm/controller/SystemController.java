package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.SystemSelectService;
import com.trkj.tsm.service.SystemService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SystemVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SystemController {
    @Resource
    private SystemService systemService;
    @Resource
    private SystemSelectService systemSelectService;

    @GetMapping("/selectAllSystemPageInfo")
    public PageInfo<SystemVo> selectAllSystemPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<SystemVo> systemPage = systemService.selectAllSystem();
        PageInfo<SystemVo> systemPageInfo = new PageInfo<>(systemPage);
        return systemPageInfo;
    }

    @PostMapping("/insertSystem")
    public SystemVo insertSystem(@RequestBody SystemVo systemVo){
        systemService.insertSystem(systemVo);
        return systemVo;
    }

    @PutMapping("/updateSystemStateGo")
    public AjaxResponse updateSystemStateGo(@RequestBody SystemVo systemVo){
        systemService.updateSystemStateGo(systemVo);
        return AjaxResponse.success();
    }

    @PutMapping("/updateSystemStateStop")
    public AjaxResponse updateSystemStateStop(@RequestBody SystemVo systemVo){
        systemService.updateSystemStateStop(systemVo);
        return AjaxResponse.success();
    }

    @PutMapping("/updateSystem")
    public AjaxResponse updateSystem(@RequestBody SystemVo systemVo){
        systemService.updateSystem(systemVo);
        return AjaxResponse.success();
    }

    @PutMapping("/deleteSystem")
    public AjaxResponse deleteSystem(@RequestBody SystemVo systemVo){
        systemService.deleteSystem(systemVo);
        return AjaxResponse.success();
    }

    @GetMapping("/selectSystemByStateYES")
    public PageInfo<SystemVo> selectSystemByStateYES(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<SystemVo> systemPage = systemService.selectSystemByStateYES();
        PageInfo<SystemVo> systemPageInfo = new PageInfo<>(systemPage);
        return systemPageInfo;
    }

    @GetMapping("/selectSystemByStateNO")
    public PageInfo<SystemVo> selectSystemByStateNO(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<SystemVo> systemPage = systemService.selectSystemByStateNO();
        PageInfo<SystemVo> systemPageInfo = new PageInfo<>(systemPage);
        return systemPageInfo;
    }

    @DeleteMapping("/deleteSystemMany")
    public AjaxResponse deleteSystemMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        systemService.deleteSystemMany(ids, updatename);
        return AjaxResponse.success();
    }

    @DeleteMapping("/updateSystemStateStopMany")
    public AjaxResponse updateSystemStateStopMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        systemService.updateSystemStateStopMany(ids,updatename);
        return AjaxResponse.success();
    }

    @DeleteMapping("/updateSystemStateGoMany")
    public AjaxResponse updateSystemStateGoMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        systemService.updateSystemStateGoMany(ids,updatename);
        return AjaxResponse.success();
    }

    @GetMapping("/selectSystemByDept")
    public PageInfo<SystemVo> selectSystemByDept(@RequestParam("what")String deptname,@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<SystemVo> systemPage=systemService.selectSystemByDept(deptname);
        PageInfo<SystemVo> systemPageInfo=new PageInfo<>(systemPage);
        return systemPageInfo;
    }

    @GetMapping("/selectSystemByTheme")
    public PageInfo<SystemVo> selectSystemByTheme(@RequestParam("what")String systemtheme,@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<SystemVo> systemPage=systemService.selectSystemByTheme(systemtheme);
        PageInfo<SystemVo> systemPageInfo=new PageInfo<>(systemPage);
        return systemPageInfo;
    }

    @GetMapping("/selectSystemByType")
    public PageInfo<SystemVo> selectSystemByType(@RequestParam("what")String systemtype,@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<SystemVo> systemPage=systemService.selectSystemByType(systemtype);
        PageInfo<SystemVo> systemPageInfo=new PageInfo<>(systemPage);
        return systemPageInfo;
    }



}
