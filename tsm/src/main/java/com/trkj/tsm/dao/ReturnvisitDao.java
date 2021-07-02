package com.trkj.tsm.dao;

import com.trkj.tsm.vo.RegisterVo;
import com.trkj.tsm.vo.ReturnvisitVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReturnvisitDao {
    int deleteByPrimaryKey(Integer returnvisitId);

    int insert(ReturnvisitVo record);

    int insertSelective(ReturnvisitVo record);

    List<ReturnvisitVo> selectByPrimaryKey(Integer registerId);//点击回访获取id

    int updateByPrimaryKeySelective(ReturnvisitVo record);

    int updateByPrimaryKey(ReturnvisitVo record);

    List<ReturnvisitVo> selectAllvisit();//显示所有

  //  List<ReturnvisitVo> selectByRegisterId(Integer rid);

    List<ReturnvisitVo> selregistertotal();//回访次数



}