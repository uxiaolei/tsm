package com.trkj.tsm.service;

import com.trkj.tsm.vo.ClassroomVo;

import java.util.List;

public interface ClassroomService {
    List<ClassroomVo> selectfinds();
    List<ClassroomVo> selectAllClassRoomsByState(int state);
    ClassroomVo addClassroom(ClassroomVo classroomVo);
    ClassroomVo updateClassroom(ClassroomVo classroomVo);
    int deleteClassroom(Integer classroomId);
}
