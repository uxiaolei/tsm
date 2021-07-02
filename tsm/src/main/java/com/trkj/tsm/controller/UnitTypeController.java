package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.UnitTypeService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitTypeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UnitTypeController {
    @Resource
    private UnitTypeService unitTypeService;

    @GetMapping("/selectAllUnitType")
    public List<UnitTypeVo> selectAllUnitType() {
        return unitTypeService.selectAllUnitType();
    }

    @GetMapping("/selectUnitTypeByName")
    public PageInfo<UnitTypeVo> selectUnitTypeByName(@RequestParam("what") String unittypeName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<UnitTypeVo> unitTypePage = unitTypeService.selectUnitTypeByName(unittypeName);
        PageInfo<UnitTypeVo> unitTypePageInfo = new PageInfo<>(unitTypePage);
        return unitTypePageInfo;
    }

    @GetMapping("/selectUnitTypePageInfo")
    public PageInfo<UnitTypeVo> selectUnitTypePageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<UnitTypeVo> unitTypePage = unitTypeService.selectAllUnitType();
        PageInfo<UnitTypeVo> unitTypePageInfo = new PageInfo<>(unitTypePage);
        return unitTypePageInfo;
    }

    @PostMapping("/insertUnitType")
    public UnitTypeVo insertUnitType(@RequestBody UnitTypeVo unitTypeVo) {
        return unitTypeService.insertUnitType(unitTypeVo);
    }

    @PutMapping("/updateUnitTypeName")
    public UnitTypeVo updateNameByPrimaryKey(@RequestBody UnitTypeVo unitTypeVo) {
        unitTypeService.updateNameByPrimaryKey(unitTypeVo);
        return unitTypeVo;
    }

    @PutMapping("/deleteUnitType")
    public UnitTypeVo deleteUnitType(@RequestBody UnitTypeVo unitTypeVo) {
        unitTypeService.deleteUnitType(unitTypeVo);
        return unitTypeVo;
    }

    @DeleteMapping("/deleteUnitTypeMany")
    public AjaxResponse deleteUnitTypeMany(@RequestParam("ids") String ids,@RequestParam("name") String name) {
        unitTypeService.deleteUnitTypeMany(ids,name);
        return AjaxResponse.success();
    }
}
