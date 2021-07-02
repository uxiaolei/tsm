package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Refund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RefundDao {
    int deleteByPrimaryKey(Integer refundId);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);

    List<Refund> seleAllRefund(@Param("classesName") String classesName);//模糊查询

    int upcwApproval(Refund refund);//修改审批

}