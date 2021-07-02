package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.BookdeliveryService;
import com.trkj.tsm.vo.Deliveryddetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class BookdeliveryController {
    @Resource
    private BookdeliveryService bookdeliveryService;

    @GetMapping("/selectdel")
    public List<Deliveryddetails> selectdel(){
        return bookdeliveryService.selectdel();
    }


    @PutMapping("/debookdel")
    public Deliveryddetails deleteByPrimaryKey(@RequestBody Deliveryddetails deliveryddetails){
        return bookdeliveryService.deleteByPrimaryKey(deliveryddetails);
    }
    @PostMapping("/insertdel")
    public Deliveryddetails insertdel(@RequestBody Deliveryddetails deliveryddetails){

        return bookdeliveryService.insertdel(deliveryddetails);
    }
    @GetMapping("/findPage2")
    public PageInfo<Deliveryddetails> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Deliveryddetails> entityPage=bookdeliveryService.selectdel();
        PageInfo<Deliveryddetails> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
    @GetMapping("/selectBookdelivery")
    public PageInfo<Deliveryddetails> selectBookdelivery (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<Deliveryddetails> entityPage=bookdeliveryService.selectBookdelivery(value);
        PageInfo<Deliveryddetails> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
