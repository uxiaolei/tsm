package com.trkj.tsm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.ClassesService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ClassesController {
    @Resource
    private ClassesService classesService;

    @GetMapping("/selectClassesAll")
    public PageInfo<ClassesVo> selectAll(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
          log.debug("开始查询班级");
        PageHelper.startPage(currentPage,pagesize);
        List<ClassesVo> entityPage=classesService.selectAll();
//        for (ClassesVo classesVo:entityPage){
//            System.out.println(classesVo.getEmp().toString()+"--------------------");
//            System.out.println(classesVo.getEmp2().toString()+"--======================-++++-------");
//        }
        PageInfo<ClassesVo> classesVoPageInfo=new PageInfo<>(entityPage);
        return classesVoPageInfo;
    }

    @PutMapping("updateClassesOpen1")
    public String updateClassesOpen1(@RequestBody @Valid  ClassesVo classesVo){
        classesService.updateClassesOpen1(classesVo.getClassesId());
        return "修改班级状态为已开班";
    }
    @PutMapping("updateClassesOpen0")
    public String updateClassesOpen0(@RequestBody @Valid  ClassesVo classesVo){
        classesService.updateClassesOpen1(classesVo.getClassesId());
        return "修改班级状态为未开班";
    }

    @PostMapping("/addClasses")
    public AjaxResponse addClasses(@RequestBody @Valid ClassesVo classesVo){
        log.debug("成功新增班级");
        classesService.addClasses(classesVo);
        return AjaxResponse.success(classesVo);
    }

    @PutMapping("/updateClasses")
    public AjaxResponse updateClasses(@RequestBody @Valid ClassesVo classesVo){
        log.debug("修改成功");
        classesService.updateClasses(classesVo);
        return AjaxResponse.success(classesVo);
    }


    @PutMapping("/deleteClasses")
    public String deleteClasses(@RequestBody @Valid ClassesVo classesVo){
        classesService.deleteClasses(classesVo);
        return "删除成功";

    }

    @GetMapping("/WJselAllclasses")
    public List<ClassesVo> WJselAllclasses() {
        log.debug("课程外键查询");
        List<ClassesVo> classesVoList = classesService.selectAll();
        return classesVoList;
    }

    @GetMapping("/selClasses2")
    public List<ClassesVo> selClasses2(@RequestParam("courseId") int courseId){
        List<ClassesVo> classesVoList = classesService.selClasses2(courseId);
        log.debug("++++++++++++++++_______________根据课程查询班级");
        return classesVoList;
    }


}
