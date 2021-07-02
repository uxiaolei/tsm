package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.BookBackService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.Bookback;
import com.trkj.tsm.vo.Deliveryddetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class BookBackController {
    @Resource
    private BookBackService bookBackService;

    @GetMapping("/selectback")
    public List<Bookback> selectback(){
        return bookBackService.selectback();
    }
    @PostMapping("/insertback")
    public AjaxResponse insertback(@RequestBody Bookback bookback){
        bookBackService.insertback(bookback);
        return AjaxResponse.success("新增成功");
    }
    @PutMapping("/delectback")
    public AjaxResponse delectback(@RequestBody Bookback bookback){
        bookBackService.delectback(bookback);
        return AjaxResponse.success("删除成功");
    }
    @PutMapping("/updateback")
    public AjaxResponse updateback(@RequestBody Bookback bookback){
        bookBackService.updateback(bookback);
        return AjaxResponse.success("修改成功");
    }
    @GetMapping("/findPage3")
    public PageInfo<Bookback> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookback> entityPage=bookBackService.selectback();
        PageInfo<Bookback> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @GetMapping("/selectbackfy")
    public PageInfo<Bookback> selectbackfy (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookback> entityPage=bookBackService.selectbackfy(value);
        PageInfo<Bookback> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
