package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Student;
import com.trkj.tsm.service.CourseService;
import com.trkj.tsm.service.StudentService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.CourseVo;
import com.trkj.tsm.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class StudentContrller {
    @Resource
    private StudentService studenService;

    @PostMapping("/addstudent")
    public AjaxResponse addstudent(@RequestBody @Valid StudentVo studentVo){
        studenService.addStudent(studentVo);
        return AjaxResponse.success(studentVo);
    }
    @PutMapping("/updatestudent")
    public AjaxResponse updatecourseState(@RequestBody @Valid StudentVo studentVo){
        studenService.updateStudent(studentVo);
        return AjaxResponse.success(studentVo);
    }

    @PutMapping("/delstudent")
    public AjaxResponse delcourse(@RequestBody @Valid StudentVo studentVo){
        studenService.deleteStudnet(studentVo);
        return AjaxResponse.success(studentVo);
    }
    @GetMapping("/selbystudentName")
    public PageInfo<StudentVo> selectfinds(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("flag") String flag){
        PageHelper.startPage(currentPage,pagesize);
        List<StudentVo> entityPage=studenService.selStudent(flag);
        PageInfo<StudentVo> StudentVoPageInfo=new PageInfo<>(entityPage);
        return StudentVoPageInfo;
    }

    @GetMapping("/selectAllpage")
    public PageInfo<StudentVo> selectAllpage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<StudentVo> entityPage=studenService.selectAllpage();
        PageInfo<StudentVo> StudentVoPageInfo=new PageInfo<>(entityPage);
        return StudentVoPageInfo;
    }

    @GetMapping("/selwjstudent")
    public List<StudentVo> WJselAllcourse(){
        log.debug("??????????????????");
        List<StudentVo> studnetVoList=studenService.selwjStudent("");
        return studnetVoList;
    }

    //??????????????????id???????????????????????????????????????
    @GetMapping("/seleSourceId")
    public List<StudentVo> seleSourceId(@RequestParam("sourceId") int sourceId){
        log.debug("??????????????????id???????????????????????????????????????");
        List<StudentVo> studentVoList=studenService.seleSourceId(sourceId);
        log.debug(studentVoList.toString());
        return studentVoList;
    }

}
