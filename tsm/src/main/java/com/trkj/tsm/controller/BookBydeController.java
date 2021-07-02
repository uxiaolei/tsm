package com.trkj.tsm.controller;

import com.trkj.tsm.service.BookByde;
import com.trkj.tsm.vo.Bookdelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class BookBydeController {
    @Resource
    private BookByde bookByde;

    @GetMapping("/selectByde")
    public List<Bookdelivery> selectByde(){
        return bookByde.selectByde();
    }

}
