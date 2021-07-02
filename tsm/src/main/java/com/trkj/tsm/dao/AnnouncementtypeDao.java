package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Announcementtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementtypeDao {
    int deleteByPrimaryKey(Integer announcementtypeId);

    int insert(Announcementtype record);

    int insertSelective(Announcementtype record);

    Announcementtype selectByPrimaryKey(Integer announcementtypeId);

    int updateByPrimaryKeySelective(Announcementtype record);

    int updateByPrimaryKey(Announcementtype record);

    List<Announcementtype> selectAllAnType();

    int updateNameById(Announcementtype announcementtype);

    int deleteById(Announcementtype announcementtype);

    List<Announcementtype> selectAnTypeByName(String announcementtypeName);
}