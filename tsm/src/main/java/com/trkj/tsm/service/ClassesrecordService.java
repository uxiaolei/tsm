package com.trkj.tsm.service;

import com.trkj.tsm.vo.ClassesrecordVo;

import java.util.List;

public interface ClassesrecordService {
    List<ClassesrecordVo> selectAllClassesRecord();
    ClassesrecordVo addClassesrecord(ClassesrecordVo classesrecordVo);
    int updateClassesrecord(ClassesrecordVo classesrecordVo);
    int deleteClassesrecord(Integer classesrecordId);
}
