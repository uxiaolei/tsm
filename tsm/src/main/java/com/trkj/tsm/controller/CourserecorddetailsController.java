package com.trkj.tsm.controller;

import com.trkj.tsm.service.CourserecorddetailsService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClasstypeVo;
import com.trkj.tsm.vo.CourserecorddetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CourserecorddetailsController {
    @Resource
    private CourserecorddetailsService courserecorddetailsService;

    @GetMapping("selectAllCourseRecorddetail")
    public List<CourserecorddetailsVo> selectAllCourseRecorddetail(){
        return courserecorddetailsService.selectAllCourseRecorddetail();
    }

    @PostMapping("/addcourserecorddetails")
    public AjaxResponse addcourse(@RequestBody @Valid List<CourserecorddetailsVo> CourserecorddetailsData){
        for (CourserecorddetailsVo c:CourserecorddetailsData){
            courserecorddetailsService.adc(c);
        }
        return AjaxResponse.success(1);
    }

    @PutMapping("/updateLearningstate1")
    public String updateLearningstate1(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate1(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为分班审核中";
    }
    @PutMapping("/updateLearningstate2")
    public String updateLearningstate2(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate2(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为学习中";
    }
    @PutMapping("/updateLearningstate3")
    public String updateLearningstate3(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate3(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为停课审核中";
    }
    @PutMapping("/updateLearningstate4")
    public String updateLearningstate4(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate4(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为停课中";
    }
    @PutMapping("/updateLearningstateE")
    public String updateLearningstate5(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate5(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为退学审核中";
    }
    @PutMapping("/updateLearningstate6")
    public String updateLearningstate6(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate6(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为已退学";
    }
    @PutMapping("/updateLearningstate7")
    public String updateLearningstate7(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate7(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为复课审核中";
    }
    @PutMapping("/updateLearningstate8")
    public String updateLearningstate8(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate8(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为转班审核中";
    }
    @PutMapping("/updateLearningstate9")
    public String updateLearningstate9(@RequestBody @Valid CourserecorddetailsVo courserecorddetailsVo ){
        courserecorddetailsService.updateLearningstate9(courserecorddetailsVo.getCourserecorddetailsId());
        return "修改学员状态为已转班";
    }
    @GetMapping("/selectAllCourseRecorddetails")
    public Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetails(@RequestParam("studentId")Integer studentId){
        log.debug("开始根据ID查询报班/报课记录&学员状态,(未分班)");
        log.debug(studentId.toString());
        return courserecorddetailsService.selectAllCourseRecorddetails(studentId);
    }
    @GetMapping("/selectAllCourseRecorddetailss")
    public Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetailss(@RequestParam("studentId")Integer studentId){
        log.debug("开始根据ID查询报班/报课记录&学员状态,(已分班)");
        log.debug(studentId.toString());
        return courserecorddetailsService.selectAllCourseRecorddetailss(studentId);
    }
    @DeleteMapping("/updateclassesId")
    public int updateclassesId (@RequestParam("courserecorddetailsId")Integer courserecorddetailsId,@RequestParam("classesId")Integer classesId){
        return  courserecorddetailsService.updateclassesId(courserecorddetailsId,classesId);
    }

}
