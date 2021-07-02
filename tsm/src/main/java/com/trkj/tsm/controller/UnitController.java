package com.trkj.tsm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.UnitService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UnitController {
    @Resource
    private UnitService unitService;

    @GetMapping("/selectAllUnitPageInfo")
    public PageInfo<UnitVo> selectAllUnitPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectAllUnit();
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @PostMapping("/insertUnit")
    public UnitVo insertUnit(@RequestBody UnitVo unitVo){
        return unitService.insertUnit(unitVo);
    }

    @PutMapping("/updateUnit")
    public UnitVo updateUnit(@RequestBody UnitVo unitVo){
        return unitService.updateUnit(unitVo);
    }

    @PutMapping("/deleteUnit")
    public UnitVo deleteUnit(@RequestBody UnitVo unitVo){
        return  unitService.deleteUnit(unitVo);
    }

    @GetMapping("/selectUnitByName")
    public PageInfo<UnitVo> selectUnitByName(@RequestParam("what") String unitName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectUnitByName(unitName);
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @GetMapping("/selectUnitByUnitTypeName")
    public PageInfo<UnitVo> selectUnitByUnitTypeName(@RequestParam("what") String unittypeName,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectUnitByUnitTypeName(unittypeName);
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @GetMapping("/selectUnitByLevel")
    public PageInfo<UnitVo> selectUnitByLevel(@RequestParam("what") String unitLevel,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectUnitByLevel(unitLevel);
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @GetMapping("/selectUnitByDirector")
    public PageInfo<UnitVo> selectUnitByDirector(@RequestParam("what") String director,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectUnitByDirector(director);
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @GetMapping("/selectUnitByAddress")
    public PageInfo<UnitVo> selectUnitByAddress(@RequestParam("what") String unitAddress,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<UnitVo> unitPage = unitService.selectUnitByAddress(unitAddress);
        PageInfo<UnitVo> unitPageInfo = new PageInfo<>(unitPage);
        return unitPageInfo;
    }

    @DeleteMapping("/deleteUnitMany")
    public AjaxResponse deleteUnitMany(@RequestParam("ids") String ids){
        unitService.deleteUnitMany(ids);
        return AjaxResponse.success();
    }
}
