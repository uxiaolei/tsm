package com.trkj.tsm.service;

import com.trkj.tsm.dao.StudentstatusDao;
import com.trkj.tsm.entity.Studentstatus;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.StudentstatusVo;
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
public class StudentstatusServiceImpl implements StudentstatusService {
    @Resource
    private StudentstatusDao studentstatusDao;


    @Override
    public List<StudentstatusVo> selectAllStudentStatus() {
        return studentstatusDao.selectAllStudentStatus();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "studentstatus",key = "#studentstatusVo.getStudentstatusId()")})//获取表名，vo类的id
    public StudentstatusVo addStudentStatus(StudentstatusVo studentstatusVo) {
        log.debug("开始新增学员状态表");
        Studentstatus s = new Studentstatus();
        BeanCopyUtil.copyProperties(studentstatusVo,s);
        studentstatusDao.insertSelective(studentstatusVo);
        return studentstatusVo;
    }

    @Override
    public int updateStudentStatus1(StudentstatusVo studentstatusVo) {
        StudentstatusVo studentstatusVo1 = new StudentstatusVo();
        BeanCopyUtil.copyProperties(studentstatusVo,studentstatusVo1);
        //设置学员状态为1
        studentstatusVo1.setStatus(1);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo1);
    }
    @Override
    public int updateStudentStatus2(StudentstatusVo studentstatusVo) {
        StudentstatusVo studentstatusVo1 = new StudentstatusVo();
        BeanCopyUtil.copyProperties(studentstatusVo,studentstatusVo1);
        //设置学员状态为2
        studentstatusVo1.setStatus(2);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo1);
    }
    @Override
    public int updateStudentStatus3(StudentstatusVo studentstatusVo) {
        StudentstatusVo studentstatusVo1 = new StudentstatusVo();
        BeanCopyUtil.copyProperties(studentstatusVo,studentstatusVo1);
        //设置学员状态为3
        studentstatusVo1.setStatus(3);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo1);
    }
    @Override
    public int updateStudentStatus0(StudentstatusVo studentstatusVo) {
        StudentstatusVo studentstatusVo1 = new StudentstatusVo();
        BeanCopyUtil.copyProperties(studentstatusVo,studentstatusVo1);
        //设置学员状态为0
        studentstatusVo1.setStatus(0);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo1);
    }

    @Override
    public int updateStudentStatus(StudentstatusVo studentstatusVo) {
        StudentstatusVo studentstatusVo1 = new StudentstatusVo();
        BeanCopyUtil.copyProperties(studentstatusVo,studentstatusVo1);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo1);
    }

    @Override
    public int deltetStudentstatus(Integer studentstatusId) {
        log.debug("开始删除*学员状态表");
        StudentstatusVo studentstatusVo = new StudentstatusVo();
        studentstatusVo.setDeletename("楼子自删");
        studentstatusVo.setDeletetime(new Date());
        studentstatusVo.setTimeliness(1);
        return studentstatusDao.updateByPrimaryKeySelective(studentstatusVo);
    }
}
