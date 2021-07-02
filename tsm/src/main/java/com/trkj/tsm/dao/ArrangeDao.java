package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Arrange;
import com.trkj.tsm.vo.ArrangeVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArrangeDao {
    int deleteByPrimaryKey(Integer arrangeId);

    int insert(Arrange record);

    int insertSelective(ArrangeVo record);

    Arrange selectByPrimaryKey(Integer arrangeId);

    int updateByPrimaryKeySelective(Arrange record);

    int updateByPrimaryKey(Arrange record);

    int addArrange(ArrangeVo arrangeVo);
}