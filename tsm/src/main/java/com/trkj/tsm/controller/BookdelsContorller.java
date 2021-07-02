package com.trkj.tsm.controller;

import com.trkj.tsm.service.Bookdeliverys;
import com.trkj.tsm.vo.Bookdelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class BookdelsContorller {
    @Resource
    private Bookdeliverys bookdeliverys;
//    @PutMapping("/debookdel")
//    public Bookdelivery deleteByPrimaryKey(@RequestBody  Bookdelivery bookdelivery){
//        bookdeliverys.deleteByPrimaryKey(bookdelivery);
//        return bookdelivery;
//    }
    @PostMapping("/insertz")
    private Bookdelivery insert(@RequestBody Bookdelivery bookdelivery){
        return bookdeliverys.insert(bookdelivery);
    }
}
