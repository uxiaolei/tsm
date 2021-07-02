package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Back;
import com.trkj.tsm.vo.BackVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BackDao {
    int deleteByPrimaryKey(Integer backId);

    int insert(Back record);

    int insertSelective(BackVo record);

    Back selectByPrimaryKey(Integer backId);

    int updateByPrimaryKeySelective(BackVo record);

    int updateByPrimaryKey(Back record);

    List<BackVo> selectAllBack();
}