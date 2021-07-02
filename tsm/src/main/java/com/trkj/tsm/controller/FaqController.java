package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.vo.Bookstorage;
import com.trkj.tsm.vo.FaqQuestions;
import com.trkj.tsm.service.FaqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class FaqController {
    @Resource
    private FaqService faqService;

    @GetMapping("/findAll")
    public List<FaqQuestions> selectAllFaq(){
        return faqService.selectAll();
    }

    @PostMapping("/Addfaq")
    public FaqQuestions insert(@RequestBody   FaqQuestions faqQuestions){
        faqQuestions.setAddname("王佳豪");
        faqQuestions.setClickcount(1);
        faqQuestions.setTimeliness(1);
        return faqService.insert(faqQuestions);
    }

    @GetMapping("/selectAll1")
    public PageInfo<FaqQuestions> selectAll1 (@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value){
        PageHelper.startPage(currentPage,pagesize);
        List<FaqQuestions> entityPage=faqService.selectAll1(value);
        PageInfo<FaqQuestions> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}