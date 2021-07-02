package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Entryfees;
import com.trkj.tsm.vo.EntryfeesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntryfeesDao {
    int deleteByPrimaryKey(Integer feesId);

    int insert(Entryfees record);

    int insertSelective(Entryfees record);

    Entryfees selectByPrimaryKey(Integer feesId);

    int updateByPrimaryKeySelective(Entryfees record);

    int updateByPrimaryKey(Entryfees record);

    List<EntryfeesVo> selectAllentryfees();//显示所有

    List<Entryfees> selefeesType();//显示预缴学费

    int upfeesState(Entryfees entryfees);//点击审核通过修改缴费状态

    int upaccumulated(Entryfees entryfees);//新增学员欠费补缴的同时修改剩余待缴金额

}