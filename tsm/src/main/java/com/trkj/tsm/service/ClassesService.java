package com.trkj.tsm.service;

import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.RegisterVo;

import java.util.List;

public interface ClassesService {
    List<ClassesVo> selectAll();
    ClassesVo addClasses(ClassesVo classesVo);
    int updateClasses(ClassesVo classesVo);
    ClassesVo deleteClasses(ClassesVo classesVo);
    int updateClassesOpen1(Integer classesId);
    int updateClassesOpen0(Integer classesId);
    List<ClassesVo> selectreclassesMH(String flag);//模糊查询
    List<ClassesVo> selClasses2(int courseId);//查询班级根据课程Id
    Classes queryById(int classid);
}
