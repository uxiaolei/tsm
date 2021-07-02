package com.trkj.tsm.service;

import com.trkj.tsm.vo.CourseVo;

import java.util.List;

public interface CourseService {
    List<CourseVo> selectCourse(String flag);
    //根据课类id查找
    List<CourseVo> selectCourse2(int classtypeid);
    CourseVo addCourse(CourseVo courseVo);
    int updateCourse(CourseVo courseVo);
    int updateCoursestate(CourseVo courseVo);
    int  deleteCourse(CourseVo courseVo);
    List<CourseVo> WjfeeesId(int feesId);//genj报班缴费id进行查询

}
