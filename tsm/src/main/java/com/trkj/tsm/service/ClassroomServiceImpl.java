package com.trkj.tsm.service;



import com.trkj.tsm.dao.ClassroomDao;
import com.trkj.tsm.entity.Classroom;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.ClassroomVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class ClassroomServiceImpl implements ClassroomService {

    @Resource
    private ClassroomDao classroomDao;


    @Override
    public List<ClassroomVo> selectfinds() {
        return classroomDao.selectfinds();
    }

    @Override
    public List<ClassroomVo> selectAllClassRoomsByState(int state) {
        return classroomDao.selectAllClassRoomsByState(state);
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "classroom",key = "#classroomVo.getClassroomId()")})
    public ClassroomVo addClassroom(ClassroomVo classroomVo) {
        log.debug("新增教室");
        Classroom c=new Classroom();
        classroomVo.setAddname("Admin");
        BeanCopyUtil.copyProperties(classroomVo,c);
        classroomDao.insertSelective(c);
        return classroomVo;
    }

    @Override
    public ClassroomVo updateClassroom(ClassroomVo classroomVo) {
        Classroom  classroom=new Classroom();
        BeanCopyUtil.copyProperties(classroomVo,classroom);
        classroomDao.updateByPrimaryKeySelective(classroom);
        return classroomVo;
    }

    @Override
    public int deleteClassroom(Integer classroomId) {
        log.debug("删除教室");
        Classroom classroom = new Classroom();
        classroom.setDeletename("贺罗金");
        classroom.setDeletetime(new Date());
        classroom.setTimeliness(1);
        return classroomDao.updateByPrimaryKeySelective(classroom);
    }


}
