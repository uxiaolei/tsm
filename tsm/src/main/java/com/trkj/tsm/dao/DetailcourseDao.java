package com.trkj.tsm.dao;

import com.trkj.tsm.vo.DetailcourseVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailcourseDao {
    int deleteByPrimaryKey(Integer detailcourseId);

    int insert(DetailcourseVo record);

    int insertSelective(DetailcourseVo record);

    DetailcourseVo selectByPrimaryKey(Integer detailcourseId);

    int updateByPrimaryKeySelective(DetailcourseVo record);

    int updateByPrimaryKey(DetailcourseVo record);
}