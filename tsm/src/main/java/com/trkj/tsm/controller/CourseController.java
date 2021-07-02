package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.dao.CourseDao;
import com.trkj.tsm.service.CourseService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassroomVo;
import com.trkj.tsm.vo.CourseVo;
import com.trkj.tsm.vo.ReturnvisitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addcourse")
    public AjaxResponse addcourse(@RequestBody @Valid CourseVo courseVo) {
        courseService.addCourse(courseVo);
        return AjaxResponse.success(courseVo);
    }

    @PutMapping("/updatecoursestate")
    public AjaxResponse updatecourseState(@RequestBody @Valid CourseVo courseVo) {
        courseService.updateCoursestate(courseVo);
        return AjaxResponse.success(courseVo);
    }

    @PutMapping("/updatecourse")
    public AjaxResponse updatecourse(@RequestBody @Valid CourseVo courseVo) {
        courseService.updateCourse(courseVo);
        return AjaxResponse.success(courseVo);
    }

    @PutMapping("/delcourse")
    public AjaxResponse delcourse(@RequestBody @Valid CourseVo courseVo) {
        courseService.deleteCourse(courseVo);
        return AjaxResponse.success(courseVo);
    }

    @GetMapping("/selAllcourse")
    public PageInfo<CourseVo> selectfinds(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("flag") String flag) {
        PageHelper.startPage(currentPage, pagesize);
        List<CourseVo> entityPage = courseService.selectCourse(flag);
        PageInfo<CourseVo> courseVoPageInfo = new PageInfo<>(entityPage);
        return courseVoPageInfo;
    }

    @GetMapping("/WJselAllcourse")
    public List<CourseVo> WJselAllcourse() {
        log.debug("课程外键查询");
        List<CourseVo> courseVoList = courseService.selectCourse("");
        return courseVoList;
    }

    @GetMapping("/selcoursebyclasstypeid")
    public List<CourseVo> selcoursebyclasstypeid(@RequestParam("classtypeid") int classtypeid) {
        List<CourseVo> courseVoList = courseService.selectCourse2(classtypeid);
        log.debug(courseVoList.toString());
        return courseVoList;
    }
    @GetMapping("/WjfeeesId")
    public List<CourseVo> WjfeeesId(@RequestParam("feesId") int feesId) {
        log.debug("点击缴费根据报班缴费id查询相关报班记录");
        List<CourseVo> courseVoList = courseService.WjfeeesId(feesId);
        return courseVoList;
    }

}
