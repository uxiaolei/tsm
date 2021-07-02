package com.trkj.tsm.service;

import com.trkj.tsm.vo.CourserecorddetailsVo;

import java.util.List;
import java.util.Map;

public interface CourserecorddetailsService {
    CourserecorddetailsVo adc(CourserecorddetailsVo courserecorddetailsVo);
    int updateLearningstate1(Integer courserecorddetailsId);
    int updateLearningstate2(Integer courserecorddetailsId);
    int updateLearningstate3(Integer courserecorddetailsId);
    int updateLearningstate4(Integer courserecorddetailsId);
    int updateLearningstate5(Integer courserecorddetailsId);
    int updateLearningstate6(Integer courserecorddetailsId);
    int updateLearningstate7(Integer courserecorddetailsId);
    int updateLearningstate8(Integer courserecorddetailsId);
    int updateLearningstate9(Integer courserecorddetailsId);
    Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetails(Integer studentId);
    Map<Integer,List<CourserecorddetailsVo>> selectAllCourseRecorddetailss(Integer studentId);
    int updateclassesId(Integer courserecorddetailsId,Integer classesId);
    List<CourserecorddetailsVo> selectAllCourseRecorddetail();
    int updateclassesIdbyid(Integer classid,Integer courserecorddetailsId);
}
