package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.SourceService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SourceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class SourceController {
    @Resource
    private SourceService sourceService;

    @GetMapping("/selectAllwjSources")
    public List<SourceVo> selectAllSources(){
        log.debug("生源渠道外键查询");
        List<SourceVo> sourceVoList=sourceService.conditionselect("");
        return sourceVoList;

    }

    @GetMapping("/selectAllSources")
    public PageInfo<SourceVo> selectAllSources(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("flag") String  flag){
        log.debug("模糊查询");
        PageHelper.startPage(currentPage, pagesize);//分页查出结果和条数
        List<SourceVo> entityPage=sourceService.conditionselect(flag);
        PageInfo<SourceVo> sourceVoPageInfo=new PageInfo<>(entityPage);
        return sourceVoPageInfo;

    }

    @PostMapping("/addsource")
    public AjaxResponse addSource(@RequestBody @Valid SourceVo sourceVo){
        sourceService.addSource(sourceVo);
        return AjaxResponse.success("新增生源渠道");
    }

   @PutMapping("/deleteupdSource")
    public AjaxResponse deleteSource(@RequestBody @Valid SourceVo sourceVo){
        sourceService.deleteSource(sourceVo.getSourceId());
        return AjaxResponse.success("删除生源渠道成功");
    }

    @PutMapping("/updSource")
    public AjaxResponse updSource (@RequestBody @Valid SourceVo sourceVo){
        sourceService.updateSource(sourceVo);
        return AjaxResponse.success("修改渠道成功");
    }


}
