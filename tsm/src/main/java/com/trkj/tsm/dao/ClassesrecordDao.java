package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Classesrecord;
import com.trkj.tsm.vo.ClassesrecordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesrecordDao {
    int deleteByPrimaryKey(Integer classesrecordId);

    int insert(ClassesrecordVo record);

    int insertSelective(ClassesrecordVo record);

    ClassesrecordVo selectByPrimaryKey(Integer classesrecordId);

    int updateByPrimaryKeySelective(ClassesrecordVo record);

    int updateByPrimaryKey(ClassesrecordVo record);

    List<ClassesrecordVo> selectAllClassesRecord();
}