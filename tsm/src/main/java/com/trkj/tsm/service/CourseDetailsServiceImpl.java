package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourseDao;
import com.trkj.tsm.dao.CourseDetailsDao;
import com.trkj.tsm.entity.Course;
import com.trkj.tsm.entity.CourseDetails;
import com.trkj.tsm.service.CourseDetailsService;
import com.trkj.tsm.vo.CourseDetailsVo;
import com.trkj.tsm.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CourseDetailsServiceImpl implements CourseDetailsService {
    @Resource
    private CourseDetailsDao coursedetailsDao;
    @Override
    public CourseDetailsVo queryById(Integer coursedetailsId) {
        return coursedetailsDao.queryById(coursedetailsId);
    }

    @Override
    public List<CourseDetails> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public CourseDetails insert(CourseDetails coursedetails) {
        return null;
    }

    @Override
    public CourseDetails update(CourseDetails coursedetails) {
        return null;
    }

    @Override
    public boolean deleteById(Integer coursedetailsId) {
        return false;
    }

    @Override
    public List<CourseDetailsVo> selectAllCourseDetails() {
        return coursedetailsDao.selectAllCourseDetails();
    }

    @Override
    @Transactional
    public void addCourseDetailsService(CourseDetailsVo coursedetailsVo) {
        coursedetailsDao.insert(coursedetailsVo);
    }

    @Override
    @Transactional
    public int updateByCourseDetailsKey(CourseDetailsVo coursedetailsVo) {
        return coursedetailsDao.updateCourseDetailsKey(coursedetailsVo);
    }

    @Override
    @Transactional
    public int deleteByCourseDetails(CourseDetailsVo coursedetailsVo) {

        return coursedetailsDao.deleteByCourseDetails(coursedetailsVo);
    }

    @Override
    public List<CourseDetailsVo> selectAllCourseDetails2() {
        return coursedetailsDao.selectAllCourseDetails2();
    }

    @Override
    public List<CourseDetailsVo> selectAllCourseDetails3(Integer courseId) {
        return coursedetailsDao.selectAllCourseDetails3(courseId);
    }

    @Override
    public int selectCourseDetailsDeleteOne(int courseId) {
        return coursedetailsDao.selectCourseDetailsDeleteOne(courseId);
    }

    @Override
    public List<CourseDetailsVo> selectArrangeInfo(int Course_Id, int coursesequence) {
        return coursedetailsDao.selectArrangeInfo(Course_Id,coursesequence);
    }
}
