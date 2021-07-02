package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Storageexpenditure;
import com.trkj.tsm.service.StorageexpenditureService;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class StorageexpenditureController {
    @Autowired
    private StorageexpenditureService storageexpenditureService;

    @GetMapping("/selectALLstorageex")
    public PageInfo<Storageexpenditure> selectALLstorageex(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询所有");
        PageHelper.startPage(currentPage,pagesize);
        List<Storageexpenditure> storageexpenditureList=storageexpenditureService.selectALLstorageex();
        PageInfo<Storageexpenditure> storageexpenditurePageInfo=new PageInfo<>(storageexpenditureList);
        return storageexpenditurePageInfo;
    }

    @PostMapping("/addstorageex")
    public AjaxResponse addstorageex(@RequestBody @Valid Storageexpenditure storageexpenditure){
        log.debug("新增成功");
        storageexpenditureService.addstorageex(storageexpenditure);
        return AjaxResponse.success(storageexpenditure);
    }


}
