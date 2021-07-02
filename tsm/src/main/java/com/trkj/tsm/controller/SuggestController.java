package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.SuggestService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SuggestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class SuggestController {
    @Resource
    private SuggestService suggestService;

    @GetMapping("/selectAllSuggestPageInfo")
    public PageInfo<SuggestVo> selectAllSuggestPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<SuggestVo> suggestPage = suggestService.selectAllSuggest();
        PageInfo<SuggestVo> suggestPageInfo = new PageInfo<>(suggestPage);
        return suggestPageInfo;
    }

    @GetMapping("/selectAllSuggestByState")
    public List<SuggestVo> selectAllSuggestByState(){
        return suggestService.selectAllSuggestByState();
    }

    @GetMapping("/selectSuggestByName")
    public PageInfo<SuggestVo> selectSuggestByName(@RequestParam("what") String suggestName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<SuggestVo> suggestPage = suggestService.selectSuggestByName(suggestName);
        PageInfo<SuggestVo> suggestPageInfo = new PageInfo<>(suggestPage);
        return suggestPageInfo;
    }

    @GetMapping("/selectSuggestByDept")
    public PageInfo<SuggestVo> selectSuggestByDept(@RequestParam("what") String deptName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<SuggestVo> suggestPage = suggestService.selectSuggestByDept(deptName);
        PageInfo<SuggestVo> suggestPageInfo = new PageInfo<>(suggestPage);
        return suggestPageInfo;
    }

    @PostMapping("/insertSuggest")
    public SuggestVo suggestVo(@RequestBody SuggestVo suggestVo) {
        return suggestService.insertSuggest(suggestVo);
    }

    @PutMapping("/updateSuggest")
    public SuggestVo updateSuggest(@RequestBody SuggestVo suggestVo) {
        log.debug("controller" + suggestVo.getDeptId());
        return suggestService.updateSuggest(suggestVo);
    }

    @PutMapping("/deleteSuggest")
    public SuggestVo deleteSuggest(@RequestBody SuggestVo suggestVo) {
        return suggestService.deleteSuggest(suggestVo);
    }

    @DeleteMapping("deleteSuggestMany")
    public AjaxResponse deleteSuggestMany(@RequestParam("ids") String ids,@RequestParam("name") String name) {
        suggestService.deleteSuggestMany(ids,name);
        return AjaxResponse.success();
    }

    @PutMapping("/updateSuggestState1")
    public AjaxResponse updateSuggestState1(@RequestBody SuggestVo suggestVo) {
        return suggestService.updateSuggestState1(suggestVo);
    }

    @PutMapping("/updateSuggestState2")
    public AjaxResponse updateSuggestState2(@RequestBody SuggestVo suggestVo) {
        return suggestService.updateSuggestState2(suggestVo);
    }
}
