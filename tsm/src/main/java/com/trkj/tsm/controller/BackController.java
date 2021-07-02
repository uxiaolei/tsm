package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.BackService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.BackVo;
import com.trkj.tsm.vo.SuspendVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class BackController {
    @Resource
    private BackService backService;

    @GetMapping("/selectAllBack")
    public PageInfo<BackVo> selectall(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询报班记录");
        PageHelper.startPage(currentPage,pagesize);
        List<BackVo> entityPage=backService.selectAllBack();
        PageInfo<BackVo> backVoPageInfo=new PageInfo<>(entityPage);
        return backVoPageInfo;
    }

    @PostMapping("/addBack")
    public AjaxResponse addBack(@RequestBody @Valid BackVo backVo){
        backService.addBack(backVo);
        return AjaxResponse.success(backVo);
    }

    @PutMapping("/updateBack")
    public AjaxResponse updateBack(@RequestBody @Valid BackVo backVo){
        backService.updateBack(backVo);
        return AjaxResponse.success(backVo);
    }
    @PutMapping("/updateBack_Approval")
    public AjaxResponse updateBack_Approval(@RequestBody @Valid BackVo backVo){
        backService.updateBack_Approval(backVo.getBackId());
        return AjaxResponse.success(backVo);
    }
    @PutMapping("/deleteBack")
    public AjaxResponse deleteBack(@RequestBody @Valid BackVo backVo){
        backService.deleteBack(backVo.getBackId());
        return AjaxResponse.success(backVo);
    }

}
