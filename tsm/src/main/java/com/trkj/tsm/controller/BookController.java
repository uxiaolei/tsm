package com.trkj.tsm.controller;

import com.trkj.tsm.entity.Book;
import com.trkj.tsm.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class BookController {
    @Resource
    private BookService bookService;
    @GetMapping("/selectbook")
    public List<Book> selectbook(){
        return bookService.selectbook();
    }

    @GetMapping("/selectBybook")
    public Book selectBybook(@RequestParam Integer bookId){
        return bookService.selectBybook(bookId);
    }

    @PostMapping("/insertbook")
    public Book insertbook(@RequestBody Book book){
        return bookService.insertbook(book);
    }

    @PutMapping("/updateBook")
    public int updateBook(@RequestBody Book bookId){
        return bookService.updateBook(bookId);
    }



}
