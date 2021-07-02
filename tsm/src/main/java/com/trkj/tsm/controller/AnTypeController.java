package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Announcementtype;
import com.trkj.tsm.service.AnTypeService;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class AnTypeController {
    @Resource
    private AnTypeService anTypeService;

    @GetMapping("/selectAllAnType")
    public List<Announcementtype> selectAllAnType(){
        return anTypeService.selectAllAnType();
    }

    @GetMapping("/selectAllAnTypePageInfo")
    public PageInfo<Announcementtype> selectAllAnTypePageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Announcementtype> anTypePage = anTypeService.selectAllAnType();
        PageInfo<Announcementtype> anTypePageInfo = new PageInfo<>(anTypePage);
        return anTypePageInfo;
    }

    @GetMapping("/selectAnTypeByName")
    public PageInfo<Announcementtype> selectAnTypeByName(@RequestParam("what") String aname,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Announcementtype> anTypePage = anTypeService.selectAnTypeByName(aname);
        PageInfo<Announcementtype> anTypePageInfo = new PageInfo<>(anTypePage);
        return anTypePageInfo;
    }

    @PostMapping("/insertAnType")
    public AjaxResponse insertAnType(@RequestBody Announcementtype announcementtype){
        anTypeService.insert(announcementtype);
        return AjaxResponse.success(announcementtype);
    }

    @PutMapping("/updateAnTypeName")
    public AjaxResponse updateNameByPrimaryKey(@RequestBody Announcementtype announcementtype){
        anTypeService.updateNameById(announcementtype);
        return AjaxResponse.success(announcementtype);
    }

    @PutMapping("/deleteAnType")
    public AjaxResponse deleteUnitType(@RequestBody Announcementtype announcementtype){
        anTypeService.deleteById(announcementtype);
        return AjaxResponse.success(announcementtype);
    }

    @DeleteMapping("/deleteAnTypeMany")
    public AjaxResponse deleteAnTypeMany(@RequestParam("ids")String ids, @RequestParam("updatename")String updatename){
        anTypeService.deleteAnTypeMany(ids, updatename);
        return AjaxResponse.success();
    }
}
