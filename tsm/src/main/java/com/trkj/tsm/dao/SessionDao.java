package com.trkj.tsm.dao;

import com.trkj.tsm.vo.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SessionDao {
    int deleteByPrimaryKey(Integer sessionId);

    int insertsession(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Integer sessionId);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

    List<Session> selectByPrimaryKey();
}