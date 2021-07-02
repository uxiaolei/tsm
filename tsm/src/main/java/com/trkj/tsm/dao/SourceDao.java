package com.trkj.tsm.dao;

import com.trkj.tsm.vo.SourceVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SourceDao {
    int deleteByPrimaryKey(Integer sourceId);

    int insert(SourceVo record);

    int insertSelective(SourceVo record);

    SourceVo selectByPrimaryKey(Integer sourceId);

    int updateByPrimaryKeySelective(SourceVo record);

    int updateByPrimaryKey(SourceVo record);

    List<SourceVo> selectAllSources();

    List<SourceVo> conditionselect(String flag);

}