package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Systemtype;
import com.trkj.tsm.service.SystemTypeService;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class SystemTypeController {
    @Resource
    private SystemTypeService systemTypeService;

    @GetMapping("selectAllSystemType")
    public List<Systemtype> selectAllSystemType(){
        return systemTypeService.selectAllSystemType();
    }

    @GetMapping("/selectAllSystemTypePageInfo")
    public PageInfo<Systemtype> selectAllSystemPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Systemtype> systemTypePage = systemTypeService.selectAllSystemType();
        PageInfo<Systemtype> systemTypePageInfo = new PageInfo<>(systemTypePage);
        return systemTypePageInfo;
    }

    @GetMapping("/selectSystemTypeByName")
    public PageInfo<Systemtype> selectSystemTypeByName(@RequestParam("what")String systemtypeName,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Systemtype> systemTypePage = systemTypeService.selectSystemTypeByName(systemtypeName);
        PageInfo<Systemtype> systemTypePageInfo = new PageInfo<>(systemTypePage);
        return systemTypePageInfo;
    }

    @PostMapping("/insertSystemType")
    public Systemtype insertSystemType(@RequestBody Systemtype systemtype){
        return systemTypeService.insert(systemtype);
    }

    @PutMapping("/updateSystemTypeName")
    public Systemtype updateNameByPrimaryKey(@RequestBody Systemtype systemtype){
        systemTypeService.updateNameById(systemtype);
        return systemtype;
    }

    @PutMapping("/deleteSystemType")
    public Systemtype deleteSystemType(@RequestBody Systemtype systemtype){
        systemTypeService.deleteById(systemtype);
        return systemtype;
    }

    @DeleteMapping("/deleteSystemTypeMany")
    public AjaxResponse deleteSystemTypeMany(@RequestParam("ids")String ids,@RequestParam("ids")String updatename){
        systemTypeService.deleteSystemTypeMany(ids,updatename);
        return AjaxResponse.success();
    }
}
