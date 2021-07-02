package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Studentoutstanding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentoutstandingDao {
    int deleteByPrimaryKey(Integer outstandingId);

    int insert(Studentoutstanding record);

    int insertSelective(Studentoutstanding record);

    Studentoutstanding selectByPrimaryKey(Integer outstandingId);

    int updateByPrimaryKeySelective(Studentoutstanding record);

    int updateByPrimaryKey(Studentoutstanding record);

    List<Studentoutstanding> seleAllstudentout();//显示所有

    int upapprovaltype(Studentoutstanding studentoutstanding);//修改审核状态

    List<Studentoutstanding> seleWapprovaltype();//查询为审核
    List<Studentoutstanding> seleYapprovaltype();//查询已审核

}