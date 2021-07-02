package com.trkj.tsm.service;

import com.trkj.tsm.dao.StudentoutstandingDao;
import com.trkj.tsm.entity.Entryfees;
import com.trkj.tsm.entity.Studentoutstanding;
import com.trkj.tsm.util.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudentoutstandingServiceImpl implements StudentoutstandingService {
    @Resource
    private StudentoutstandingDao studentoutstandingDao;

    @Override
    public List<Studentoutstanding> seleAllstudentout() {
        return studentoutstandingDao.seleAllstudentout();
    }

    @Override
    public Studentoutstanding addStudentoutstanding(Studentoutstanding studentoutstanding) {
        log.debug("新增学员欠费管理记录");
        Studentoutstanding st=new Studentoutstanding();
        BeanCopyUtil.copyProperties(studentoutstanding,st);
        String num="Bj";//定义一个固定值
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");//时间的精确值
        String outname=num+dateFormat.format(new Date())+st.toString().length();
        st.setOutstandingName(outname);
        st.setOutstandingDate(new Date());
        studentoutstandingDao.insertSelective(st);
        log.debug(st.toString());
        return st;
    }

    @Override
    public int approvaltype(Studentoutstanding studentoutstanding) {
        log.debug("点击审核修改");
        studentoutstanding.setApprovalType(1);
        studentoutstanding.setApprovaltime(new Date( ));
        return studentoutstandingDao.upapprovaltype(studentoutstanding);
    }

    @Override
    public List<Studentoutstanding> seleWapprovaltype() {
        log.debug("未审核");
        return studentoutstandingDao.seleWapprovaltype();
    }

    @Override
    public List<Studentoutstanding> seleYapprovaltype() {
        log.debug("已审核");
        return studentoutstandingDao.seleYapprovaltype();
    }
}
