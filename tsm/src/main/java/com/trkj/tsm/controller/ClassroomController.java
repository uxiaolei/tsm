package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Classroom;
import com.trkj.tsm.service.ClassroomService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassroomVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/selectfinds")
    public PageInfo<ClassroomVo> selectfinds(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<ClassroomVo> entityPage=classroomService.selectfinds();
        PageInfo<ClassroomVo> classroomVoPageInfo=new PageInfo<>(entityPage);
        return classroomVoPageInfo;
    }
    @GetMapping("/selectAllClassRoomsByState")
    public AjaxResponse selectfinds(@RequestParam("state") int state){
        List<ClassroomVo> classroomVos=classroomService.selectAllClassRoomsByState(state);
        return AjaxResponse.success(classroomVos);
    }
    @PostMapping("/addclassroom")
    public AjaxResponse addclassroom(@RequestBody @Valid ClassroomVo classroomVo){
        classroomService.addClassroom(classroomVo);
        return AjaxResponse.success(classroomVo);
    }
    @DeleteMapping("/delclassroom")
    public String delclassroom(@RequestBody @Valid Classroom classroom){
        classroomService.deleteClassroom(classroom.getClassroomId());
        return "删除成功";
    }
    @PutMapping("/updclassroom")
    public AjaxResponse updateclassroom(@RequestBody @Valid ClassroomVo classroomVo){
        classroomService.updateClassroom(classroomVo);
        return AjaxResponse.success(classroomVo);
    }

}
