package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Classroom;
import com.trkj.tsm.vo.ClassroomVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassroomDao {
    int deleteByPrimaryKey(Integer classroomId);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer classroomId);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);

    List<ClassroomVo> selectfinds();

    List<ClassroomVo> selectAllClassRoomsByState(int TimeLiness);
}