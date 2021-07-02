package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Student;
import com.trkj.tsm.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
    int deleteByPrimaryKey(Integer studentId);

    int insert(StudentVo record);

    int insertSelective(StudentVo record);

    StudentVo selectByPrimaryKey(Integer studentId);

    List<StudentVo> selectBystudentName(String flag);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(StudentVo record);

    List<StudentVo> seleSourceId(Integer sourceId);

    List<StudentVo> selectAllpage();
}