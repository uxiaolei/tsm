package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Interview;
import com.trkj.tsm.service.InterviewService;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping("/selAllInterview")
    public List<Interview> selAllInterview(@RequestParam("studentId") int studentId){
        log.debug("根据studentId id查询相关访谈记录");
        List<Interview> interviewList=interviewService.selAllInterview(studentId);
        return interviewList;
    }

    @PostMapping("/addinterview")
    public AjaxResponse addinterview(@RequestBody @Valid Interview interview){
        log.debug("新增学员访谈记录");
        interviewService.addinterview(interview);
        return AjaxResponse.success(interview);
    }

    @PutMapping("/delinterview")
    public String delinterview(@RequestBody @Valid Interview interview){
        interviewService.delinterview(interview);
        return "删除成功";
    }

}
