package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.ReturnvisitService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.ReturnvisitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class ReturnvisitController {
    @Autowired
    private ReturnvisitService returnvisitService;

/*    @GetMapping("/selectAllvisit")
    public PageInfo<ReturnvisitVo> selectAllvisit(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询显示所有");
        PageHelper.startPage(currentPage,pagesize);
        List<ReturnvisitVo> entityVisit=returnvisitService.selectAllvisit();
        PageInfo<ReturnvisitVo> returnVoPageInfo=new PageInfo<>(entityVisit);
        return returnVoPageInfo;

    }*/
    @GetMapping("/Wjxsreturnvisit")
    public List<ReturnvisitVo> Wjxsurnvisit(@RequestParam("registerId") int registerId){
        log.debug("点击回访查询咨询登记id");
        List<ReturnvisitVo> returnvisitVoList=returnvisitService.selectByPrimaryKey(registerId);
        return returnvisitVoList;
    }
    @GetMapping("/selregistertotal")
    public List<ReturnvisitVo> selregistertotal(){
        List<ReturnvisitVo> returnvisitVoList=returnvisitService.selregistertotal();
        return returnvisitVoList;
    }


    @GetMapping("/Wjselectreturnvisit")
    public List<ReturnvisitVo> Wjselectreturnvisit(){
        log.debug("回访表外键显示");
        List<ReturnvisitVo> returnvisitVoList=returnvisitService.selectAllvisit();
        return returnvisitVoList;
    }

    @PostMapping("/addreturnvisit")
    public AjaxResponse addreturnvisit(@RequestBody @Valid ReturnvisitVo returnvisitVo){
        returnvisitService.addreturnvisit(returnvisitVo);
        return AjaxResponse.success("给此学员新增一条回访记录");
    }

    @PutMapping("/dereturnvisit")
    public AjaxResponse dereturnvisit(@RequestBody @Valid ReturnvisitVo returnvisitVo){
        returnvisitService.dereturnvisit(returnvisitVo.getReturnvisitId());
        return AjaxResponse.success("删除了此学员的回访记录");
    }


}
