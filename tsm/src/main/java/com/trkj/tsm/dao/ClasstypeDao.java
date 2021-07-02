package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Classtype;
import com.trkj.tsm.vo.ClasstypeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClasstypeDao {
    int deleteByPrimaryKey(Integer classtypeId);

    int insert(Classtype record);

    ClasstypeVo selectByPrimaryKey(Integer classtypeId);

    int updateByPrimaryKeySelective(ClasstypeVo record);

    int updateByPrimaryKey(Classtype record);

    List<ClasstypeVo> selectClasstypes();
}