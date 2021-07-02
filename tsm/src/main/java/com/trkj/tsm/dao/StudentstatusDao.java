package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Studentstatus;
import com.trkj.tsm.vo.StudentstatusVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentstatusDao {
    int deleteByPrimaryKey(Integer studentstatusId);

    int insert(StudentstatusVo record);

    int insertSelective(StudentstatusVo record);

    StudentstatusVo selectByPrimaryKey(Integer studentstatusId);

    int updateByPrimaryKeySelective(StudentstatusVo record);

    int updateByPrimaryKey(StudentstatusVo record);

    List<StudentstatusVo> selectAllStudentStatus();
}