package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.OpjournalService;
import com.trkj.tsm.vo.OpjournalVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@Slf4j
public class OpjournalController {
    @Resource
    private OpjournalService opjournalService;

    @GetMapping("/selectAllOpJPageInfo")
    public PageInfo<OpjournalVo> selectAllOpJPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectAllOpJ();
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return  opjournalVoPageInfo;
    }

    @GetMapping("/selectOpJByOpcontent")
    public PageInfo<OpjournalVo> selectOpJByOpcontent(@RequestParam("what")String what,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectOpJByOpcontent(what);
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return  opjournalVoPageInfo;
    }

    @GetMapping("/selectOpJByOperator")
    public PageInfo<OpjournalVo> selectOpJByOperator(@RequestParam("what")String what,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectOpJByOperator(what);
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return  opjournalVoPageInfo;
    }

    @GetMapping("/selectOpJByOpTiome")
    public PageInfo<OpjournalVo> selectOpJByOpTiome(@RequestParam("time")String time,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectOpJByOpTiome(time);
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return  opjournalVoPageInfo;
    }

    @GetMapping("/selectOpJByOpTiomeAndOperator")
    public PageInfo<OpjournalVo> selectOpJByOpTiomeAndOperator(@RequestParam("time")String time,@RequestParam("what")String what,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectOpJByOpTiomeAndOperator(time,what);
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return opjournalVoPageInfo;
    }

    @GetMapping("/selectOpJByOpTiomeAndOpContent")
    public PageInfo<OpjournalVo> selectOpJByOpTiomeAndOpContent(@RequestParam("time")String time,@RequestParam("what")String what,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<OpjournalVo> opjournalVos=opjournalService.selectOpJByOpTiomeAndOpContent(time,what);
        PageInfo<OpjournalVo> opjournalVoPageInfo=new PageInfo<>(opjournalVos);
        return opjournalVoPageInfo;
    }

}
