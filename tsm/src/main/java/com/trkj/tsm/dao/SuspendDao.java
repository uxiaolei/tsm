package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Suspend;
import com.trkj.tsm.vo.SuspendVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuspendDao {
    int deleteByPrimaryKey(Integer suspendId);

    int insert(SuspendVo record);

    int insertSelective(Suspend record);

    SuspendVo selectByPrimaryKey(Integer suspendId);

    int updateByPrimaryKeySelective(SuspendVo record);

    int updateByPrimaryKey(SuspendVo record);

    List<SuspendVo> selectAllSuspend ();
}