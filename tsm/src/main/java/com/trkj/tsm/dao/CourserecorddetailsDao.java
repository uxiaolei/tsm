package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.entity.Courserecorddetails;
import com.trkj.tsm.vo.CourserecordVo;
import com.trkj.tsm.vo.CourserecorddetailsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourserecorddetailsDao {
    int deleteByPrimaryKey(Integer courserecorddetailsId);

    int insert(CourserecorddetailsVo record);

    int insertSelective(Courserecorddetails record);

    CourserecorddetailsVo selectByPrimaryKey(Integer courserecorddetailsId);

    int updateByPrimaryKeySelective(CourserecorddetailsVo record);

    int updateByPrimaryKey(CourserecorddetailsVo record);

    List<CourserecorddetailsVo> selectAllCourseRecorddetails(Integer studentId);

    List<CourserecorddetailsVo> selectAllCourseRecorddetailss(Integer studentId);

    int updateclassesId(@Param("courserecorddetailsId") Integer courserecorddetailsId,@Param("classesId") Integer classesId);

    List<CourserecorddetailsVo> selectAllCourseRecorddetail();
}