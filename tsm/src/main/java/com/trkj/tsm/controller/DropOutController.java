package com.trkj.tsm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.DropOutService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.DropoutVo;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.drop.Drop;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class DropOutController {
    @Resource
    private DropOutService dropOutService;

    @GetMapping("/selectAllDrop")
    private PageInfo<DropoutVo> selectAllDrop (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询退学表");
        PageHelper.startPage(currentPage,pagesize);
        List<DropoutVo> entityPage = dropOutService.selectAllDrop();
        PageInfo<DropoutVo> dropoutVoPageInfo = new PageInfo<>(entityPage);
        return dropoutVoPageInfo;
    }

    @GetMapping("/selectDrops")
    private List<DropoutVo> selectDrops (DropoutVo dropoutVo){
        return dropOutService.selectAllDrop();
    }

    @PostMapping("/addDrop")
    private AjaxResponse addDrop(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.addDrop(dropoutVo);
        return AjaxResponse.success(dropoutVo);
    }

    @PutMapping("/updateDrop")
    private AjaxResponse updateDrop(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.updateDrop(dropoutVo);
        return AjaxResponse.success(dropoutVo);
    }
    @PutMapping("/updateDropisPay1")
    private AjaxResponse updateDropisPay1(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.updateDropisPay1(dropoutVo.getDropId());
        return AjaxResponse.success(dropoutVo);
    }
    @PutMapping("/updateDropisPay2")
    private AjaxResponse updateDropisPay2(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.updateDropisPay2(dropoutVo.getDropId());
        return AjaxResponse.success(dropoutVo);
    }

    @PutMapping("/updateDropJW_Approval0")
    private AjaxResponse updateDropJW_Approval0(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.updateDropJW_Approval0(dropoutVo.getDropId());
        return AjaxResponse.success(dropoutVo);
    }

    @PutMapping("/updateDropJW_Approval1")
    private AjaxResponse updateDropJW_Approval1(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.updateDropJW_Approval1(dropoutVo.getDropId());
        return AjaxResponse.success(dropoutVo);
    }

    @PutMapping("/deleteDrop")
    private String deleteDrop(@RequestBody @Valid DropoutVo dropoutVo){
        dropOutService.deleteDrop(dropoutVo.getDropId());
        return "删除成功";
    }

}
