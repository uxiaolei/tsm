package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourserecordDao;
import com.trkj.tsm.dao.CourserecorddetailsDao;
import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.entity.Courserecorddetails;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.CourserecordVo;
import com.trkj.tsm.vo.CourserecorddetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CourserecorddetailsServiceImpl implements CourserecorddetailsService {
    @Resource
    private CourserecorddetailsDao courserecorddetailsDao;
    @Resource
    private CourserecordDao courserecordDao;
    @Override
    public CourserecorddetailsVo adc(CourserecorddetailsVo courserecorddetailsVo) {
        Courserecorddetails courserecorddetails=new Courserecorddetails();
        BeanCopyUtil.copyProperties(courserecorddetailsVo,courserecorddetails);
        courserecorddetailsDao.insertSelective(courserecorddetails);
        return courserecorddetailsVo;
    }
    //分班审核
    @Override
    public int updateLearningstate1(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo1 = new CourserecorddetailsVo();
        courserecorddetailsVo1.setLearningstate(1);
        courserecorddetailsVo1.setCourserecorddetailsId(courserecorddetailsId);
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo1);
    }

    //学习中
    @Override
    public int updateLearningstate2(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo2 = new CourserecorddetailsVo();
        courserecorddetailsVo2.setLearningstate(2);
        courserecorddetailsVo2.setCourserecorddetailsId(courserecorddetailsId);
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo2);
    }

    //停课审核中
    @Override
    public int updateLearningstate3(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo3 = new CourserecorddetailsVo();
        courserecorddetailsVo3.setLearningstate(3);
        courserecorddetailsVo3.setCourserecorddetailsId(courserecorddetailsId);
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo3);
    }

    //停课中
    @Override
    public int updateLearningstate4(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo4 = new CourserecorddetailsVo();
        courserecorddetailsVo4.setLearningstate(4);
        courserecorddetailsVo4.setCourserecorddetailsId(courserecorddetailsId);

        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo4);
    }

    //退学审核中
    @Override
    public int updateLearningstate5(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo5 = new CourserecorddetailsVo();


        courserecorddetailsVo5.setCourserecorddetailsId(courserecorddetailsId);
        courserecorddetailsVo5.setLearningstate(5);
        log.debug(courserecorddetailsVo5.toString());
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo5);
    }

    //已退学
    @Override
    public int updateLearningstate6(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo6 = new CourserecorddetailsVo();
        courserecorddetailsVo6.setLearningstate(6);
        courserecorddetailsVo6.setCourserecorddetailsId(courserecorddetailsId);
        log.debug(courserecorddetailsVo6.toString()+"111111");
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo6);
    }

    //复课审核中
    @Override
    public int updateLearningstate7(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo7 = new CourserecorddetailsVo();
        courserecorddetailsVo7.setLearningstate(7);
        courserecorddetailsVo7.setCourserecorddetailsId(courserecorddetailsId);

        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo7);
    }
    //转班审核中
    @Override
    public int updateLearningstate8(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo8 = new CourserecorddetailsVo();
        courserecorddetailsVo8.setLearningstate(8);
        courserecorddetailsVo8.setCourserecorddetailsId(courserecorddetailsId);

        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo8);
    }

    //已转班
    @Override
    public int updateLearningstate9(Integer courserecorddetailsId) {
        CourserecorddetailsVo courserecorddetailsVo9 = new CourserecorddetailsVo();
        courserecorddetailsVo9.setLearningstate(9);
        courserecorddetailsVo9.setCourserecorddetailsId(courserecorddetailsId);
        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo9);
    }

    @Override
    public Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetails(Integer studentId) {
        log.debug(studentId+"+++++++++++++++++++++++++++++=");
      List<CourserecordVo> courserecordVoList= courserecordDao.selectStudentId(studentId);

     Map<Integer,List<CourserecorddetailsVo>> courserecorddetailsVoMap = new HashMap<>();
      for(CourserecordVo s:courserecordVoList){
          log.debug(s.getCourserecordId()+"....................");
          List<CourserecorddetailsVo> courserecorddetailsVoList1 = courserecorddetailsDao.selectAllCourseRecorddetails(s.getCourserecordId());
          log.debug(courserecorddetailsVoList1.size()+"qqqqqqqqqqqqqqqqqqqqqqqqqqq");
          if(courserecorddetailsVoList1 != null){
              courserecorddetailsVoMap.put(s.getCourserecordId(),courserecorddetailsVoList1);
          }
      }
      log.debug(courserecorddetailsVoMap.toString());
        return courserecorddetailsVoMap;
    }

    @Override
    public Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetailss(Integer studentId) {
        log.debug(studentId+"+-+-+-+-+-+-++--++-+-+-+-+-+-+-+-+-+-+-+++++++++=");
        List<CourserecordVo> courserecordVoList= courserecordDao.selectStudentId(studentId);
        Map<Integer,List<CourserecorddetailsVo>> courserecorddetailsVoMap = new HashMap<>();
        for(CourserecordVo s:courserecordVoList){
            log.debug(s.getCourserecordId()+".,.,.,.,.,.,..,.,.,.,.,.,.,.,.,.,.,.,.,");
            List<CourserecorddetailsVo> courserecorddetailsVoList1 = courserecorddetailsDao.selectAllCourseRecorddetailss(s.getCourserecordId());
            log.debug(courserecorddetailsVoList1.size()+"pppppppppppppppppppppppppppppp");
            if(courserecorddetailsVoList1 != null){
                courserecorddetailsVoMap.put(s.getCourserecordId(),courserecorddetailsVoList1);
            }

        }
        log.debug(courserecorddetailsVoMap.toString());
        return courserecorddetailsVoMap;
    }

    @Override
    public int updateclassesId(Integer courserecorddetailsId,Integer classesId) {
        CourserecorddetailsVo courserecorddetailsVo = new CourserecorddetailsVo();
        return courserecorddetailsDao.updateclassesId(courserecorddetailsId,classesId);
    }

    @Override
    public List<CourserecorddetailsVo> selectAllCourseRecorddetail() {
        return courserecorddetailsDao.selectAllCourseRecorddetail();
    }

    @Override
    public int updateclassesIdbyid(Integer classid, Integer courserecorddetailsId) {
        return courserecorddetailsDao.updateclassesId(courserecorddetailsId,classid);
    }


}
