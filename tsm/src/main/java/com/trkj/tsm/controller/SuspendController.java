package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.SuspendService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SuspendVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class SuspendController {
    @Resource
    private SuspendService suspendService;

    @GetMapping("/selectAllSuspend")
    public List<SuspendVo> selectAllSuspend(){
        return suspendService.selectAllSuspend();
    }

    @GetMapping("/selectAllSuspends")
    public PageInfo<SuspendVo> selectall(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<SuspendVo> entityPage=suspendService.selectAllSuspend();
        PageInfo<SuspendVo> suspendVoPageInfo=new PageInfo<>(entityPage);
        return suspendVoPageInfo;
    }


    @PostMapping("/addSuspend")
    public AjaxResponse addSuspend(@RequestBody @Valid SuspendVo suspendVo){
        suspendService.addSuspend(suspendVo);
        return AjaxResponse.success(suspendVo);
    }

    @PutMapping("/updateSuspend")
    public AjaxResponse updateSuspend(@RequestBody @Valid SuspendVo suspendVo){
        suspendService.updateSuspend(suspendVo);
        return AjaxResponse.success(suspendVo);
    }
    @PutMapping("/updateSuspend_Approval1")
    public AjaxResponse updateSuspend_Approval1(@RequestBody @Valid SuspendVo suspendVo){
        suspendService.updateSuspend_Approval1(suspendVo.getSuspendId());
        return AjaxResponse.success(suspendVo);
    }
    @PutMapping("/deleteSuspend")
    public AjaxResponse deleteSuspend(@RequestBody @Valid SuspendVo suspendVo){
        suspendService.deleteSuspend(suspendVo.getSuspendId());
        return AjaxResponse.success(suspendVo);
    }
}
