package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourseDao;
import com.trkj.tsm.entity.Course;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    @Override
    public List<CourseVo> selectCourse(String flag) {
        List<CourseVo> list=courseDao.selCourse(flag);
        return list;
    }

    //根据课类id查找课程
    @Override
    public List<CourseVo> selectCourse2(int classtypeid) {

        return courseDao.selCourse2(classtypeid);
    }


    /**
     * 新增课程
     * @param courseVo
     * @return
     */

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "couorse",key = "#courseVo.getCourseId()")})
    public CourseVo addCourse(CourseVo courseVo) {
        Course course=new Course();
        BeanCopyUtil.copyProperties(courseVo,course);
        course.setAddname("Admin");
        course.setCourseState("0");
        course.setClasstypeId(course.getClasstype().getClasstypeId());
        courseDao.insertSelective(course);
        return courseVo;
    }

    /**
     * 修改课程
     * @param courseVo
     * @return
     */
    @Override
    public int updateCourse(CourseVo courseVo) {
        Course course=new Course();
        BeanCopyUtil.copyProperties(courseVo,course);
        course.setUpdatetime(new Date());
        course.setUpdatename("updat");

        course.setClasstypeId(courseVo.getClasstype().getClasstypeId());
        return  courseDao.updateByPrimaryKeySelective(course) ;
    }

    /**
     * 开设，停报
     * @param courseVo
     * @return
     */
    @Override
    public int updateCoursestate(CourseVo courseVo) {
        Course course=new Course();
        course.setClasstypeId(courseVo.getClasstype().getClasstypeId());
        course.setCourseId(courseVo.getCourseId());
        if(courseVo.getCourseState().equals("0")){
            course.setStopname("stop");
            course.setStoptime(new Date());
            course.setCourseState("1");
        }else {
            course.setBeginname("begin");
            course.setBegintime(new Date());
            course.setCourseState("0");
        }
        return courseDao.updateByPrimaryKeySelective(course);

    }

    /**
     * 删除
     * @param courseVo
     * @return
     */
    @Override
    public int deleteCourse(CourseVo courseVo) {
        Course course=new Course();
        BeanCopyUtil.copyProperties(courseVo,course);
        course.setDeletename("delte");
        course.setDeletetime(new Date());
        course.setTimeliness(1);
        course.setClasstypeId(courseVo.getClasstype().getClasstypeId());
        return  courseDao.updateByPrimaryKeySelective(course) ;
    }

    @Override
    public List<CourseVo> WjfeeesId(int feesId) {
        log.debug("点击学员缴费");
        return courseDao.selectByPrimaryKey(feesId);
    }


}
