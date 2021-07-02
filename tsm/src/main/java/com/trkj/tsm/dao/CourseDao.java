package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Course;
import com.trkj.tsm.vo.CourseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer courseId);

    int insert(CourseVo record);

    int insertSelective(Course record);

    List<CourseVo> selectByPrimaryKey(Integer feesId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(CourseVo record);

    List<CourseVo>  selCourse(String  flag);

    List<CourseVo>  selCourse2(int classtypeid);
}