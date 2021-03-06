package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Systemtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemtypeDao {
    int deleteByPrimaryKey(Integer systemtypeId);

    int insert(Systemtype record);

    int insertSelective(Systemtype record);

    Systemtype selectByPrimaryKey(Integer systemtypeId);

    int updateByPrimaryKeySelective(Systemtype record);

    int updateByPrimaryKey(Systemtype record);

    List<Systemtype> selectAllSystemType();

    int updateNameById(Systemtype systemtype);

    int deleteById(Systemtype systemtype);

    List<Systemtype> selectSystemTypeByName(String systemtypeName);
}