package com.trkj.tsm.service;

import com.trkj.tsm.vo.StudentstatusVo;

import java.util.List;

public interface StudentstatusService {
    List<StudentstatusVo> selectAllStudentStatus();
    StudentstatusVo addStudentStatus(StudentstatusVo studentstatusVo);
    int updateStudentStatus1(StudentstatusVo studentstatusVo);
    int updateStudentStatus2(StudentstatusVo studentstatusVo);
    int updateStudentStatus3(StudentstatusVo studentstatusVo);
    int updateStudentStatus0(StudentstatusVo studentstatusVo);
    int updateStudentStatus(StudentstatusVo studentstatusVo);
    int deltetStudentstatus(Integer studentstatusId);
}
