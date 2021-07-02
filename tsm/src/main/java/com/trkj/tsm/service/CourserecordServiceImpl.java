package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourserecordDao;
import com.trkj.tsm.entity.Courserecord;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.CourserecordVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CourserecordServiceImpl implements CourserecordService {
    @Resource
    private CourserecordDao courserecordDao;
    @Override
    public Courserecord add(CourserecordVo courserecordVo) {
        Courserecord courserecord=new Courserecord();
        BeanCopyUtil.copyProperties(courserecordVo,courserecord);
        courserecord.setAddname("Admin");
        courserecordDao.insertSelective(courserecord);
        return courserecord;
    }

}
