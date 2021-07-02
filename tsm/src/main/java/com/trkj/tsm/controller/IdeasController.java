package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.IdeasService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.IdeasVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class IdeasController {
    @Resource
    private IdeasService ideasService;

    @GetMapping("/selectAllIdeasByEmpName")
    public PageInfo<IdeasVo> selectAllIdeasByEmpName(@RequestParam("what") String empname,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectAllIdeasByEmpName(empname);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectAllIdeasBySuggestName")
    public PageInfo<IdeasVo> selectAllIdeasBySuggestName(@RequestParam("what") String suggestname,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectAllIdeasBySuggestName(suggestname);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectAllIdeasByTitle")
    public PageInfo<IdeasVo> selectAllIdeasByTitle(@RequestParam("what") String title,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectAllIdeasByTitle(title);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectAllIdeasByState")
    public PageInfo<IdeasVo> selectAllIdeasByState(@RequestParam("state") Integer state,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectAllIdeasByState(state);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectAllIdeas")
    public PageInfo<IdeasVo> selectAllIdeas(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectAllIdeas();
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasBySuggest")
    public PageInfo<IdeasVo> selectIdeasBySuggest(@RequestParam("empId") Integer empId, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        List<IdeasVo> ideasPage = ideasService.selectIdeasBySuggest(empId,currentPage,pagesize);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasByEmpId")
    public PageInfo<IdeasVo> selectIdeasByEmpId(@RequestParam("empId") Integer empId, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectIdeasByEmpId(empId);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasBySuggestAndEmpName")
    public PageInfo<IdeasVo> selectIdeasBySuggestAndEmpName(@RequestParam("empId") Integer empId,@RequestParam("what") String empName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        List<IdeasVo> ideasPage = ideasService.selectIdeasBySuggestAndEmpName(empId,empName,currentPage,pagesize);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasBySuggestAndReply")
    public PageInfo<IdeasVo> selectIdeasBySuggestAndReply(@RequestParam("empId") Integer empId,@RequestParam("what") String reply, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        List<IdeasVo> ideasPage = ideasService.selectIdeasBySuggestAndReply(empId,reply,currentPage,pagesize);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasBySuggestAndTitle")
    public PageInfo<IdeasVo> selectIdeasBySuggestAndTitle(@RequestParam("empId") Integer empId,@RequestParam("what") String ideasTitle, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        log.debug(empId.toString());
        log.debug(String.valueOf(currentPage));
        List<IdeasVo> ideasPage = ideasService.selectIdeasBySuggestAndTitle(empId,ideasTitle,currentPage,pagesize);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasByEmpIdAndEmpName")
    public PageInfo<IdeasVo> selectIdeasByEmpIdAndEmpName(@RequestParam("empId") Integer empId,@RequestParam("what") String empName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectIdeasByEmpIdAndEmpName(empId,empName);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasByEmpIdAndReply")
    public PageInfo<IdeasVo> selectIdeasByEmpIdAndReply(@RequestParam("empId") Integer empId,@RequestParam("what") String reply, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectIdeasByEmpIdAndReply(empId,reply);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasByEmpIdAndTitle")
    public PageInfo<IdeasVo> selectIdeasByEmpIdAndTitle(@RequestParam("empId") Integer empId,@RequestParam("what") String ideasTitle, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectIdeasByEmpIdAndTitle(empId,ideasTitle);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasBySuggestAndState")
    public PageInfo<IdeasVo> selectIdeasBySuggestAndState(@RequestParam("empId") Integer empId,@RequestParam("state") Integer state, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        List<IdeasVo> ideasPage = ideasService.selectIdeasBySuggestAndState(empId, state, currentPage, pagesize);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @GetMapping("/selectIdeasByEmpIdAndState")
    public PageInfo<IdeasVo> selectIdeasByEmpIdAndState(@RequestParam("empId") Integer empId,@RequestParam("state") Integer state, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<IdeasVo> ideasPage = ideasService.selectIdeasByEmpIdAndState(empId, state);
        PageInfo<IdeasVo> ideasPageInfo = new PageInfo<>(ideasPage);
        return ideasPageInfo;
    }

    @PostMapping("/insertIdeas")
    public AjaxResponse insertIdeas(@RequestBody IdeasVo ideasVo) {
        ideasService.insertIdeas(ideasVo);
        return AjaxResponse.success();
    }

    @PutMapping("/replyIdeas")
    public AjaxResponse replyIdeas(@RequestBody IdeasVo ideasVo) {
        ideasService.replyIdeas(ideasVo);
        return AjaxResponse.success();
    }

    @PutMapping("/deleteIdeas")
    public AjaxResponse deleteIdeas(@RequestBody IdeasVo ideasVo) {
        ideasService.deleteIdeas(ideasVo);
        return AjaxResponse.success();
    }

    @PutMapping("/noLookIdeas")
    public AjaxResponse noLookIdeas(@RequestBody IdeasVo ideasVo) {
        ideasService.noLookIdeas(ideasVo);
        return AjaxResponse.success();
    }

    @DeleteMapping("/deleteIdeasMany")
    public AjaxResponse deleteIdeasMany(@RequestParam("ids")String ids,@RequestParam("name")String name){
        ideasService.deleteIdeasMany(ids,name);
        return AjaxResponse.success();
    }

    @DeleteMapping("/noLookIdeasMany")
    public AjaxResponse noLookIdeasMany(@PathVariable("ids")String ids){
        ideasService.noLookIdeasMany(ids);
        return AjaxResponse.success();
    }

}
