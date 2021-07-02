package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Integer bookId);

    int insertbook(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    Book selectBybook(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateBook(Book bookId);

    List<Book> selectbook();
}