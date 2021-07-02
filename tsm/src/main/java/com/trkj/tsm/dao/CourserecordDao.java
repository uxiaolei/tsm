package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.vo.CourserecordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourserecordDao {
    int deleteByPrimaryKey(Integer courserecordId);

    int insert(Courserecord record);

    int insertSelective(Courserecord record);

    Courserecord selectByPrimaryKey(Integer courserecordId);

    int updateByPrimaryKeySelective(Courserecord record);

    int updateByPrimaryKey(Courserecord record);

    List<CourserecordVo> selectStudentId(Integer studentId);
}