package com.trkj.tsm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Studentstatus;
import com.trkj.tsm.service.StudentstatusService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassesrecordVo;
import com.trkj.tsm.vo.StudentstatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class StudentstatusController {
    @Resource
    private StudentstatusService studentstatusService;

    @GetMapping("selectAllStudentstatus")
    public PageInfo<StudentstatusVo> selectall(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询学员信息*学员状态表");
        PageHelper.startPage(currentPage,pagesize);
        List<StudentstatusVo> entityPage = studentstatusService.selectAllStudentStatus();
        PageInfo<StudentstatusVo> studentstatusVoPageInfo = new PageInfo<>(entityPage);
        return studentstatusVoPageInfo;
    }

    @GetMapping("selectAlls")
    public List<StudentstatusVo> selectalls(){
        return studentstatusService.selectAllStudentStatus();
    }

    @PostMapping("addStudentstatus")
    public AjaxResponse addStudentstatus(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.addStudentStatus(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }

    @PutMapping("updateStudentStatus")
    public AjaxResponse updateStudentStatus(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.updateStudentStatus(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }

    @PutMapping("updateStudentStatus0")
    public AjaxResponse updateStudentStatus0(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.updateStudentStatus0(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }
    @PutMapping("updateStudentStatus1")
    public AjaxResponse updateStudentStatus1(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.updateStudentStatus1(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }
    @PutMapping("updateStudentStatus2")
    public AjaxResponse updateStudentStatus2(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.updateStudentStatus2(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }
    @PutMapping("updateStudentStatus3")
    public AjaxResponse updateStudentStatus3(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.updateStudentStatus3(studentstatusVo);
        return AjaxResponse.success(studentstatusVo);
    }

    @PutMapping("deltetStudentstatus")
    public String deltetStudentstatus(@RequestBody @Valid StudentstatusVo studentstatusVo){
        studentstatusService.deltetStudentstatus(studentstatusVo.getStudentstatusId());
        return "删除成功";
    }

}
