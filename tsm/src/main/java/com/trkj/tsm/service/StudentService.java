package com.trkj.tsm.service;

import com.trkj.tsm.vo.CourseVo;
import com.trkj.tsm.vo.StudentVo;

import java.util.List;

public interface StudentService {
    List<StudentVo> selStudent(String flag);
    StudentVo addStudent(StudentVo studentVo);
    int updateStudent(StudentVo studentVo);
    int  deleteStudnet(StudentVo studentVo);
    List<StudentVo> selwjStudent(String flag);
    List<StudentVo> seleSourceId(Integer sourceId);//根据生源渠道id显示该生源渠道下的学员信息
    List<StudentVo> selectAllpage();
}
