package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookDao;
import com.trkj.tsm.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Override
    public Book selectByPrimaryKey(Integer bookId) {
//        selectBybook(bookId).setDeliverycount(1);

        return bookDao.selectByPrimaryKey(bookId);
    }
    @Override
    public List<Book> selectbook(){

        return bookDao.selectbook();
    }

    @Override
    public int updateBook(Book bookId) {
        return bookDao.updateBook(bookId);
    }

    @Override
    public Book insertbook(Book book){
        book.setStorage(14);
       bookDao.insertSelective(book);
       return book;
    }

    @Override
    public Book selectBybook(Integer bookId) {
        return bookDao.selectBybook(bookId);
    }
}
