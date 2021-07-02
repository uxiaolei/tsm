package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Entryfees;
import com.trkj.tsm.service.EntryfeesService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EntryfeesVo;
import com.trkj.tsm.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class EntryfeesController {
    @Autowired
    private EntryfeesService entryfeesService;

    @GetMapping("/WjselectAllentryfees")
    public List<EntryfeesVo> WjselectAllentryfees(){
        log.debug("报班缴费外键查询");
        List<EntryfeesVo> entryfeesVoList=entryfeesService.selectAllentryfees();
        return entryfeesVoList;
    }

    @GetMapping("/selectAllentryfees")
    public PageInfo<EntryfeesVo> selectAllentryfees(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询显示所有");
        PageHelper.startPage(currentPage,pagesize);
        List<EntryfeesVo> entryfeesVoList=entryfeesService.selectAllentryfees();
        PageInfo<EntryfeesVo> entryfeesVoPageInfo=new PageInfo<>(entryfeesVoList);
        return  entryfeesVoPageInfo;
    }

    @GetMapping("/selefeesType")
    public PageInfo<Entryfees> selefeesType(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        log.debug("查询显示缴费状态为1的");
        PageHelper.startPage(currentPage, pagesize);
        List<Entryfees> entryfeesVoList = entryfeesService.selefeesType();
        PageInfo<Entryfees> entryfeesVoPageInfo = new PageInfo<>(entryfeesVoList);
        return entryfeesVoPageInfo;
    }

    @PutMapping("/deleteEntryfees")
    public AjaxResponse deleteEntryfees(@RequestBody @Valid EntryfeesVo entryfeesVo){
        entryfeesService.deleteEntryfees(entryfeesVo.getFeesId());
        return AjaxResponse.success("成功删除班缴费记录");
    }

    @PutMapping("/upentryfees")
    public AjaxResponse upentryfees(@RequestBody @Valid Entryfees entryfees){
        entryfeesService.upentryfees(entryfees);
        return AjaxResponse.success("成功修改报班缴费记录");
    }

    @PostMapping("/addentryfees")
    public AjaxResponse addentryfees(@RequestBody @Valid Entryfees entryfees){
        entryfeesService.addentryfees(entryfees);
        return AjaxResponse.success("成功新增报班缴费记录");
    }

    @PutMapping("/upfeesState")
    public AjaxResponse upfeesState(@RequestBody @Valid Entryfees entryfees){
        log.debug("修改缴费状态---------");
        entryfeesService.upfeesState(entryfees);
        return AjaxResponse.success(entryfees);
    }

    @PutMapping("/upaccumulated")
    public AjaxResponse upaccumulated(@RequestBody @Valid Entryfees entryfees){
        log.debug("修改剩余待缴金额成功");
        entryfeesService.upaccumulated(entryfees);
        return AjaxResponse.success("成功修改剩余代缴金额");
    }

}
