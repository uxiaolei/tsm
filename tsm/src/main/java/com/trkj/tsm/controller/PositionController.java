package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.PositionService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.PositionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PositionController {
    @Resource
    private PositionService positionService;

    @GetMapping("/selectAllPosition")
    public List<PositionVo> selectAllPosition() {
        return positionService.selectAllPosition();
    }

    @GetMapping("/selectAllPositionPageInfo")
    public PageInfo<PositionVo> selectAllPositionPageInfo(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<PositionVo> positionPage = positionService.selectAllPosition();
        PageInfo<PositionVo> positionPageInfo = new PageInfo<>(positionPage);
        return positionPageInfo;
    }

    @PostMapping("/inserPosition")
    public PositionVo inserPosition(@RequestBody PositionVo positionVo) {
        positionService.insertPosition(positionVo);
        return positionVo;
    }

    @PutMapping("/updatePosition")
    public PositionVo updatePosition(@RequestBody PositionVo positionVo) {
        positionService.updatePosition(positionVo);
        return positionVo;
    }

    @PutMapping("/deletePosition")
    public PositionVo deletePosition(@RequestBody PositionVo positionVo) {
        positionService.deletePosition(positionVo);
        return positionVo;
    }

    @GetMapping("/selectPositionByName")
    public PageInfo<PositionVo> selectPositionByName(@RequestParam("what") String positionName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<PositionVo> positionPage = positionService.selectPositionByName(positionName);
        PageInfo<PositionVo> positionPageInfo = new PageInfo<>(positionPage);
        return positionPageInfo;
    }

    @PutMapping("/deletePositionMany/{ids}")
    public AjaxResponse deletePositionMany(@PathVariable("ids") String ids) {
        positionService.deletePositionMany(ids);
        return AjaxResponse.success();
    }
}
