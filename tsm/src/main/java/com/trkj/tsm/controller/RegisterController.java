package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.entity.Courserecorddetails;
import com.trkj.tsm.entity.Student;
import com.trkj.tsm.service.CourserecordService;
import com.trkj.tsm.service.CourserecorddetailsService;
import com.trkj.tsm.service.RegisterService;
import com.trkj.tsm.service.StudentService;
import com.trkj.tsm.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController//
@Slf4j
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourserecordService courserecordService;//总
    @Autowired
    private CourserecorddetailsService courserecorddetailsService;//详情

    @GetMapping("/WjselectregisterAll")
    public List<RegisterVo> WjselectregisterAll(){
        log.debug("咨询登记外键查询");
        List<RegisterVo> registerVoList=registerService.selectregisterAlls();
        return registerVoList;
    }
    /*通过咨询登记的id获取生源渠道的id*/
    @GetMapping("/selectsouid")
    public RegisterVo selectByPrimaryKey(@RequestParam("registerId") Integer registerId){
        log.debug("获取生源渠道的id");
        RegisterVo registerVo=registerService.selectByPrimaryKey(registerId);//接收前端传过来的咨询id
        StudentVo studentVo=new StudentVo();//new学员实体类
        studentVo.setRegisterId(registerId);//学员里的咨询id=前端传的id
        //studentVo.setClassesId(1);
        String num="XH";//定义一个固定值
        DateFormat dateFormat=new SimpleDateFormat("hhmmss");//时间的精确值
        String feesname=num+dateFormat.format(new Date())+studentVo.toString().length();
        studentVo.setStudentNumber(feesname);
        studentVo.setStudytime(new Date());
        studentVo.setStudentPhone(registerVo.getPhone());
        studentVo.setSex(registerVo.getSex());
        studentVo.setStudentName(registerVo.getConsultant());
        studentVo.setSourceId(registerVo.getSourceId());
        StudentVo studentVo1=studentService.addStudent(studentVo);//返回接收student id 根据impl里面return返回的vo/entity

        CourserecordVo cours=new CourserecordVo();
        cours.setAddname("hlj");
        cours.setEmpId(1);
        cours.setReceipts(BigDecimal.valueOf(0.000));
        cours.setStudentId(studentVo1.getStudentId());
        Courserecord courserecord=courserecordService.add(cours);//返回接收courserecord id 根据impl里面return返回的vo/entity

        CourserecorddetailsVo coursersVo=new CourserecorddetailsVo();
        coursersVo.setCourseId(registerVo.getCourseId());
        coursersVo.setRemarks("hhhhhhhhhh");
        coursersVo.setCourserecordId(courserecord.getCourserecordId());
        courserecorddetailsService.adc(coursersVo);//返回接收courserecord id 根据impl里面return返回的vo/entity
        return registerVo;
    }

    @GetMapping("/selectregisterAll")
    public PageInfo<RegisterVo> selectregisterAll(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("flag") String flag){
        log.debug("模糊查询显示所有");
        PageHelper.startPage(currentPage,pagesize);
        List<RegisterVo> entityPage=registerService.mhselectregister(flag);
        PageInfo<RegisterVo> registerVoPageInfo=new PageInfo<>(entityPage);
        return registerVoPageInfo;

    }

    @PostMapping("/addregister")
    public AjaxResponse addRegister(@RequestBody @Valid RegisterVo registerVo){
        registerService.addRegister(registerVo);
        return AjaxResponse.success("成功新增咨询登记");
    }

    @PutMapping("/updateregister")
    public AjaxResponse updateregister(@RequestBody @Valid RegisterVo registerVo){
        registerService.updateRegister(registerVo);
        return AjaxResponse.success("成功修改咨询登记");
    }

    @PutMapping("/upPayState")
    public AjaxResponse upPayState(@RequestBody @Valid RegisterVo registerVo){
        log.debug("修改缴费状态成功");
        registerService.upPayState(registerVo);
        return AjaxResponse.success(registerVo);
    }


    @PutMapping("/deleteRegister")
    public AjaxResponse deleteRegister(@RequestBody @Valid RegisterVo registerVo){
        registerService.deleteRegister(registerVo.getRegisterId());
        return AjaxResponse.success("成功删除咨询登记");
        
    }

    //报表统计中统计每种咨询方式的使用次数
    @GetMapping("/selBbzxfs")
    public AjaxResponse ConsultationmodeStatistics(){
        return AjaxResponse.success(registerService.ConsultationmodeStatistics());
    }



}
