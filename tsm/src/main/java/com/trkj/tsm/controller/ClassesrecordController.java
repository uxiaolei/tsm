package com.trkj.tsm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Classesrecord;
import com.trkj.tsm.service.ClassesService;
import com.trkj.tsm.service.ClassesrecordService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.ClassesrecordVo;
import com.trkj.tsm.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ClassesrecordController {
    @Resource
    private ClassesrecordService classesrecordService;

    @GetMapping("/selectAllClassesrecord")
    public PageInfo<ClassesrecordVo> selectall(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询报班记录");
        PageHelper.startPage(currentPage,pagesize);
        List<ClassesrecordVo> entityPage=classesrecordService.selectAllClassesRecord();
        PageInfo<ClassesrecordVo> classesrecordVoPageInfo=new PageInfo<>(entityPage);
        return classesrecordVoPageInfo;
    }

    @PostMapping("/addClassesrecord")
    public AjaxResponse addClassesrecord(@RequestBody @Valid ClassesrecordVo classesrecordVo){
        log.debug("新增成功");
        classesrecordService.addClassesrecord(classesrecordVo);
        return AjaxResponse.success(classesrecordVo);
    }

    @PutMapping("/updateClassesrecord")
    public AjaxResponse updateClassesrecord(@RequestBody @Valid ClassesrecordVo classesrecordVo){
        log.debug("修改成功");
        classesrecordService.updateClassesrecord(classesrecordVo);
        return AjaxResponse.success(classesrecordVo);
    }


    @PutMapping("/deleteClassesrecord")
    public String deleteClassesrecord(@RequestBody @Valid ClassesrecordVo classesrecordVo){
        classesrecordService.deleteClassesrecord(classesrecordVo.getClassesrecordId());
        return "删除成功";

    }
}
