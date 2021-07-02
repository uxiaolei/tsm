package com.trkj.tsm.dao;

import com.trkj.tsm.vo.Deliveryddetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeliveryddetailsDao {
    int deleteByPrimaryKey(Integer deliveryddetailsId);

    int insertdel(Deliveryddetails record);

    int insertSelective(Deliveryddetails record);

//    Deliveryddetails selectdel1();

    int updateByPrimaryKeySelective(Deliveryddetails record);

    int updateByPrimaryKey(Deliveryddetails record);

    List<Deliveryddetails> selectdel();
    List<Deliveryddetails> selectBookdelivery(String bookname);
}