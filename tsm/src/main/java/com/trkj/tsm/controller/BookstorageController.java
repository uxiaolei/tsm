package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.BookstorService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.Bookstorage;
import com.trkj.tsm.vo.Deliveryddetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class BookstorageController {
    @Resource
    private BookstorService bookstorService;

    @GetMapping("/selectBookstor")
    public List<Bookstorage>selectBookstor(){
        return bookstorService.selectBookstor();
    }

    @GetMapping("/findPage1")
    public PageInfo<Bookstorage> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorService.selectBookstor();
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PostMapping("/addBookstorage")
    public AjaxResponse addBookstorage(@RequestBody Bookstorage bookstorage){
        bookstorService.addBookstorage(bookstorage);
        return AjaxResponse.success("");
    }

    @PutMapping("/updateBookstorage")
    public Bookstorage updateByPrimaryKey(@RequestBody Bookstorage bookstorage){
        log.debug("开始修改");
        bookstorService.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @PutMapping("/delectbookstor")
    public Bookstorage deleteByPrimaryKey(@RequestBody Bookstorage bookstorage){
        return bookstorService.deleteByPrimaryKey(bookstorage);
    }

    @GetMapping("/selectbookname")
    public PageInfo<Bookstorage> selectbookname (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorService.selectbookname(value);
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @GetMapping("/selectpress")
    public PageInfo<Bookstorage> selectpress (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorService.selectpress(value);
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }


}
