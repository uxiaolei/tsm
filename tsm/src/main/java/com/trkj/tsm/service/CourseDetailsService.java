package com.trkj.tsm.service;

import com.trkj.tsm.entity.CourseDetails;
import com.trkj.tsm.vo.CourseDetailsVo;

import java.util.List;

/**
 * 课程详细表(CourseDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-02 11:02:48
 */
public interface CourseDetailsService {
    CourseDetailsVo queryById(Integer coursedetailsId);
    List<CourseDetails> queryAllByLimit(int offset, int limit);
    CourseDetails insert(CourseDetails coursedetails);
    CourseDetails update(CourseDetails coursedetails);
    public boolean deleteById(Integer coursedetailsId);

    public List<CourseDetailsVo> selectAllCourseDetails();
    public void addCourseDetailsService(CourseDetailsVo coursedetailsVo);
    public int updateByCourseDetailsKey(CourseDetailsVo coursedetailsVo);
    public int deleteByCourseDetails(CourseDetailsVo coursedetailsVo);
    public List<CourseDetailsVo> selectAllCourseDetails2();
    public List<CourseDetailsVo> selectAllCourseDetails3(Integer courseId);
    public int selectCourseDetailsDeleteOne(int courseId);
    List<CourseDetailsVo> selectArrangeInfo(int Course_Id,int coursesequence);
}
