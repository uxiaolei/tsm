package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Classtype;
import com.trkj.tsm.service.ClasstypeService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.ClasstypeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class ClasstypeController {
    @Resource
    private ClasstypeService classtypeService;

    @GetMapping("/selectClasstypeAll")
    public PageInfo<ClasstypeVo> selectAll(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询班级");
        PageHelper.startPage(currentPage,pagesize);
        List<ClasstypeVo> entityPage=classtypeService.selectClasstypes();
        PageInfo<ClasstypeVo> classtypeVoPageInfo=new PageInfo<>(entityPage);
        return classtypeVoPageInfo;
    }

    @GetMapping("/selectClasstypes")
    public List<ClasstypeVo> selectClasstypes(){
        //log.debug("开始查询所有");
        return classtypeService.selectClasstypes();
    }

    @PostMapping("/addClasstypes")
    public Classtype addClasstypes(@RequestBody Classtype classtype){
        //log.debug(classtype.toString());
        classtype=classtypeService.addClasstypes(classtype);
        return classtype;
    }


    @PutMapping("/updateClasstype")
    public AjaxResponse updateClasses(@RequestBody @Valid ClasstypeVo classtypeVo){
        log.debug("修改成功");
        classtypeService.updateClasstypes(classtypeVo);
        return AjaxResponse.success(classtypeVo);
    }

    @PutMapping("/deleteClasstypes")
    public String deleteClasstypes(@RequestBody @Valid ClasstypeVo classtypeVo){
        classtypeService.deleteByClasstypesId(classtypeVo.getClasstypeId());
        return "删除成功";
    }
}
