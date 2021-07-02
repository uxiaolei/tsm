package com.trkj.tsm.dao;

import com.trkj.tsm.vo.Bookdelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookdeliveryDao {
    int deleteByPrimaryKey(Integer bookdeliveryId);

    int insert(Bookdelivery record);

    int insertSelective(Bookdelivery record);

//    Bookdelivery selectByPrimaryKey(Integer bookdeliveryId);

    int updateByPrimaryKeySelective(Bookdelivery record);

    int updateByPrimaryKey(Bookdelivery record);

    List<Bookdelivery> selectByde();
}