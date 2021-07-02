package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Memorandumattachment;
import com.trkj.tsm.entity.Studentoutstanding;
import com.trkj.tsm.service.StudentoutstandingService;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class StudentoutstandingController {
    @Autowired
    private StudentoutstandingService studentoutstandingService;

    @GetMapping("/seleAllstudentout")
    public PageInfo<Studentoutstanding> seleAllstudentout(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询所有");
        PageHelper.startPage(currentPage,pagesize);
        List<Studentoutstanding> studentoutstandings=studentoutstandingService.seleAllstudentout();
        PageInfo<Studentoutstanding> studentoutstandingPageInfo=new PageInfo<>(studentoutstandings);
        return studentoutstandingPageInfo;

    }

    @PostMapping("/addStudentoutstanding")
    public AjaxResponse addStudentoutstanding(@RequestBody @Valid Studentoutstanding studentoutstanding){
        log.debug("新增成功");
        studentoutstandingService.addStudentoutstanding(studentoutstanding);
        return AjaxResponse.success("成功新增欠费补缴记录");
    }

    @GetMapping("/seleWapprovaltype")
    public PageInfo<Studentoutstanding> seleWapprovaltype(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询未审核");
        PageHelper.startPage(currentPage,pagesize);
        List<Studentoutstanding> studentoutstandings=studentoutstandingService.seleWapprovaltype();
        PageInfo<Studentoutstanding> studentoutstandingPageInfo=new PageInfo<>(studentoutstandings);
        return studentoutstandingPageInfo;

    }

    @GetMapping("/seleYapprovaltype")
    public PageInfo<Studentoutstanding> seleYapprovaltype(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询已审核");
        PageHelper.startPage(currentPage,pagesize);
        List<Studentoutstanding> studentoutstandings=studentoutstandingService.seleYapprovaltype();
        PageInfo<Studentoutstanding> studentoutstandingPageInfo=new PageInfo<>(studentoutstandings);
        return studentoutstandingPageInfo;

    }


    @PutMapping("/upapprovaltype")
    public AjaxResponse upapprovaltype(@RequestBody @Valid Studentoutstanding studentoutstanding){
        log.debug("审核成功");
        studentoutstandingService.approvaltype(studentoutstanding);
        return AjaxResponse.success(studentoutstanding);
    }

}
