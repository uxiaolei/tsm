package com.trkj.tsm.service;

import com.trkj.tsm.entity.Book;

import java.util.List;

public interface BookService {
    Book selectByPrimaryKey(Integer bookId);
    List<Book> selectbook();
    int updateBook(Book bookId);
    Book insertbook(Book book);
    Book selectBybook(Integer bookId);
}
