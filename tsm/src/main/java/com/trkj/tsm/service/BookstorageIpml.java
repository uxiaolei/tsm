package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookDao;
import com.trkj.tsm.dao.BookstorageDao;
import com.trkj.tsm.entity.Book;
import com.trkj.tsm.vo.Bookstorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BookstorageIpml implements BookstorService{
    @Resource
    private BookstorageDao bookstorageDao;
    @Resource
    private BookDao bookDao;

    @Override
    public List<Bookstorage>selectBookstor(){
        return bookstorageDao.selectBookstor();
    }

    @Override
    public List<Bookstorage> selectbookname(String bookname) {
        return null;
    }

    @Override
    public List<Bookstorage> selectpress(String press) {
        return null;
    }

    @Override
    public Bookstorage addBookstorage(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal booksprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= booksprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorageDao.addBookstorage(bookstorage);
        return bookstorage;
    }

    @Override
    public Bookstorage updateByPrimaryKey(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal booksprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= booksprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorageDao.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @Override
    public Bookstorage deleteByPrimaryKey(Bookstorage bookstorage){
        bookstorage.setTimeliness(1);
        bookstorage.setDeletetime(new Date());
        bookstorageDao.updateByPrimaryKeySelective(bookstorage);
        return bookstorage;
    }
}
