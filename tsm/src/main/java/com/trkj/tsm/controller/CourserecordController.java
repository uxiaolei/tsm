package com.trkj.tsm.controller;

import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.service.CourseService;
import com.trkj.tsm.service.CourserecordService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.CourseVo;
import com.trkj.tsm.vo.CourserecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Slf4j
public class CourserecordController {

    @Resource
    private CourserecordService courserecordService;

    @PostMapping("/addcourserecord")
    public AjaxResponse addcourse(@RequestBody @Valid CourserecordVo courserecordVo){
        log.debug(courserecordVo.toString());
        Courserecord courserecord=courserecordService.add(courserecordVo);
        return AjaxResponse.success(courserecord);
    }
}
