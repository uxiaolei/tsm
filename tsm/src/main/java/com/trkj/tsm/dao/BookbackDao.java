package com.trkj.tsm.dao;

import com.trkj.tsm.vo.Bookback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookbackDao {
    int deleteback(Integer bookbackId);

    int insertback(Bookback record);

    int insertSelective(Bookback record);

//    Bookback selectback(Integer bookbackId);

    int updateByPrimaryKeySelective(Bookback record);

    int updateback(Bookback record);

    List<Bookback> selectback();
    List<Bookback> selectbackfy( String bookname);
}