package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.AnService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AnController {
    @Resource
    private AnService anService;

    @GetMapping("/selectAllAnPageInfo")
    public PageInfo<AnnouncementVo> SelectAllAnPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAllAn();
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @GetMapping("/selectAnByStateYES")
    public PageInfo<AnnouncementVo> selectAnByStateYES(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAnByStateYES();
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @GetMapping("/selectAnByStateNO")
    public PageInfo<AnnouncementVo> selectAnByStateNO(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAnByStateNO();
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @GetMapping("/selectAnByType")
    public PageInfo<AnnouncementVo> selectAnByType(@RequestParam("what") String announcementtypeName,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAnByType(announcementtypeName);
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @GetMapping("/selectAnByContent")
    public PageInfo<AnnouncementVo> selectAnByContent(@RequestParam("what") String announcementContent,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAnByContent(announcementContent);
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @GetMapping("/selectAnByTheme")
    public PageInfo<AnnouncementVo> selectAnByTheme(@RequestParam("what") String announcementTheme,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<AnnouncementVo> announcementPage=anService.selectAnByTheme(announcementTheme);
        PageInfo<AnnouncementVo> announcementPageInfo=new PageInfo<>(announcementPage);
        return announcementPageInfo;
    }

    @PostMapping("/insertAn")
    public AnnouncementVo insertAn(@RequestBody AnnouncementVo announcementVo){
        return anService.insertAn(announcementVo);
    }

    @PutMapping("/updateAn")
    public AjaxResponse updateAn(@RequestBody AnnouncementVo announcementVo){
        anService.updateAn(announcementVo);
        return AjaxResponse.success();
    }

    @PutMapping("/deleteAn")
    public AjaxResponse deleteAn(@RequestBody AnnouncementVo announcementVo){
        anService.deleteAn(announcementVo);
        return AjaxResponse.success();
    }

    @PutMapping("/updateAnStateGo")
    public AjaxResponse updateAnStateGo(@RequestBody AnnouncementVo announcementVo){
        anService.updateAnStateGo(announcementVo);
        return AjaxResponse.success();
    }

    @PutMapping("/updateAnStateStop")
    public AjaxResponse updateAnStateStop(@RequestBody AnnouncementVo announcementVo){
        anService.updateAnStateStop(announcementVo);
        return AjaxResponse.success();
    }

    @DeleteMapping("/updateAnStateGoMany")
    public AjaxResponse updateAnStateGoMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        anService.updateAnStateGoMany(ids,updatename);
        return AjaxResponse.success();
    }

    @DeleteMapping("/updateAnStateStopMany")
    public AjaxResponse updateAnStateStopMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        anService.updateAnStateStopMany(ids,updatename);
        return AjaxResponse.success();
    }

    @DeleteMapping("/deleteAnMany")
    public AjaxResponse deleteAnMany(@RequestParam("ids")String ids,@RequestParam("updatename")String updatename){
        anService.deleteAnMany(ids,updatename);
        return AjaxResponse.success();
    }

}
