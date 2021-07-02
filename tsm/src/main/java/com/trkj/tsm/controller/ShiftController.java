package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.dao.ClassesDao;
import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.service.CourseDetailsService;
import com.trkj.tsm.service.CourserecorddetailsService;
import com.trkj.tsm.service.ShiftService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.ShiftVo;
import com.trkj.tsm.vo.SuspendVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class ShiftController {
    @Resource
    private ShiftService shiftService;
    @Resource
    private CourserecorddetailsService courserecorddetailsService;
    @Resource
    private ClassesDao classesDao;


    @GetMapping("/selectAllShift")
    public List<ShiftVo> selectAllShift(){
        return shiftService.selectAllShift();
    }

    @PutMapping("/updatecourserecorddetails")
    public AjaxResponse updatecourserecorddetails(@RequestBody @Valid ShiftVo shiftVo){
        Classes classes=classesDao.selectreclassesbyClasses_Name(shiftVo.getNewclass());
        courserecorddetailsService.updateclassesIdbyid(classes.getClassesId(),shiftVo.getCourserecorddetailsId());
        return AjaxResponse.success("转班成功");
    }


    @GetMapping("/selectAllShifts")
    public PageInfo<ShiftVo> selectAllShifts(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<ShiftVo> entityPage=shiftService.selectAllShift();
        PageInfo<ShiftVo> shiftVoPageInfo=new PageInfo<>(entityPage);
        return shiftVoPageInfo;
    }

    @PostMapping("/addShift")
    public AjaxResponse addShift(@RequestBody @Valid ShiftVo shiftVo){
        log.debug(shiftVo.toString());
        shiftService.addShift(shiftVo);
        return AjaxResponse.success("成功申请转班");
    }

    @PutMapping("/updateShift")
    public AjaxResponse updateShift(@RequestBody @Valid ShiftVo shiftVo){
        shiftService.updateShift(shiftVo);
        return AjaxResponse.success(shiftVo);
    }
    @PutMapping("/appShift_Approval1")
    public AjaxResponse appShift_Approval1(@RequestBody @Valid ShiftVo shiftVo){
        shiftService.appShift_Approval1(shiftVo.getShiftId());
        return AjaxResponse.success(shiftVo);
    }
    @PutMapping("/deleteShift")
    public AjaxResponse deleteShift(@RequestBody @Valid ShiftVo shiftVo){
        shiftService.deleteShift(shiftVo.getShiftId());
        return AjaxResponse.success(shiftVo);
    }
}
