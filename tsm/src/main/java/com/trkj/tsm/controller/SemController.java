package com.trkj.tsm.controller;

import com.trkj.tsm.service.SemService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SemesterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class SemController {
    @Resource
    private SemService semService;

    @GetMapping("/selectByPrimaryKey")
    public List<SemesterVo> selectByPrimaryKey(){

        return semService.selectByPrimaryKey();
    }

    @PostMapping("/insertSelective")
    public AjaxResponse insert(@RequestBody SemesterVo semestervo){
        semestervo.setAddname("梁政");
        semestervo.setAddtime(new Date());
        semestervo.setTimeliness(0);
        return AjaxResponse.success("");
    }
    @PutMapping("/updatesemester")
    public AjaxResponse updatesem(@RequestBody SemesterVo semestervo){

        semestervo.setDeletename("梁政");
        semestervo.setDeletetime(new Date());
        semestervo.setTimeliness(0);
        return AjaxResponse.success("");
    }
    @PutMapping("/delectsem")
    public AjaxResponse deletesem(@RequestBody SemesterVo semestervo){

        return AjaxResponse.success("");

    }
}
