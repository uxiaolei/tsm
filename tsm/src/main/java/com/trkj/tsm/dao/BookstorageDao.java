package com.trkj.tsm.dao;

import com.trkj.tsm.vo.Bookstorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookstorageDao {
    int deleteByPrimaryKey(Integer mbookstorageId);

    int insert(Bookstorage record);

    int insertSelective(Bookstorage record);

//    Bookstorage selectByPrimaryKey(Integer mbookstorageId);

    int updateByPrimaryKeySelective(Bookstorage record);

    int updateByPrimaryKey(Bookstorage record);

    List<Bookstorage>selectBookstor();
    List<Bookstorage>selectbookname(String bookname);
    List<Bookstorage>selectpress(String press);
    int addBookstorage(Bookstorage record);


}