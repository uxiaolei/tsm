package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.LoginJournalService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.LoginjournalVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

@RestController
@Slf4j
public class LoginJController {
    @Resource
    private LoginJournalService loginJournalService;

    @GetMapping("/selectAllLoginJPageInfo")
    public PageInfo<LoginjournalVo> selectAllLoginJPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<LoginjournalVo> loginjournalVos=loginJournalService.selectAllLoginJ();
        PageInfo<LoginjournalVo> loginjournalVoPageInfo=new PageInfo<>(loginjournalVos);
        return loginjournalVoPageInfo;
    }

    @GetMapping("/selectLoginJByEmp")
    public PageInfo<LoginjournalVo> selectLoginJByEmp(@RequestParam("what") String empname,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<LoginjournalVo> loginjournalVos=loginJournalService.selectLoginJByEmp(empname);
        PageInfo<LoginjournalVo> loginjournalVoPageInfo=new PageInfo<>(loginjournalVos);
        return loginjournalVoPageInfo;
    }

    @GetMapping("/selectLoginJByLoginTime")
    public PageInfo<LoginjournalVo> selectLoginJByLoginTime(@RequestParam("time") String logintime,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<LoginjournalVo> loginjournalVos=loginJournalService.selectLoginJByLoginTime(logintime);
        PageInfo<LoginjournalVo> loginjournalVoPageInfo=new PageInfo<>(loginjournalVos);
        return loginjournalVoPageInfo;
    }

    @GetMapping("/selectLoginJByLoginTimeAndEmp")
    public PageInfo<LoginjournalVo> selectLoginJByLoginTimeAndEmp(@RequestParam("time") String logintime,@RequestParam("what") String empname,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<LoginjournalVo> loginjournalVos=loginJournalService.selectLoginJByLoginTimeAndEmp(logintime,empname);
        PageInfo<LoginjournalVo> loginjournalVoPageInfo=new PageInfo<>(loginjournalVos);
        return loginjournalVoPageInfo;
    }


}
