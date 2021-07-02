package com.trkj.tsm.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SemesterDao {
    int deletesem(Integer semesterId);

    int insert(com.trkj.tsm.vo.SemesterVo record);

    int insertSelective(com.trkj.tsm.vo.SemesterVo record);

    com.trkj.tsm.vo.SemesterVo selectByPrimaryKey(Integer semesterId);

    int updateByPrimaryKeySelective(com.trkj.tsm.vo.SemesterVo record);

    int updatesem(com.trkj.tsm.vo.SemesterVo record);

    List<com.trkj.tsm.vo.SemesterVo> selectByPrimaryKey();
}