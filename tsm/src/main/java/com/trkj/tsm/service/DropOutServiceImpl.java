package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourserecorddetailsDao;
import com.trkj.tsm.dao.DropoutDao;
import com.trkj.tsm.entity.Dropout;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.CourserecorddetailsVo;
import com.trkj.tsm.vo.DropoutVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DropOutServiceImpl implements DropOutService {
    @Resource
    private DropoutDao dropoutDao;
//    @Resource
//    private CourserecorddetailsDao courserecorddetailsDao;
    @Override
    public List<DropoutVo> selectAllDrop() {
        return dropoutDao.selectAllDrop();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "dropout",key = "#dropoutVo.getDropId()")})//获取表名，vo类的id
    public DropoutVo addDrop(DropoutVo dropoutVo) {
        log.debug("开始新增学员退学表");
        Dropout d = new Dropout();
        BeanCopyUtil.copyProperties(dropoutVo,d);
        dropoutVo.setDropHandler("梁子");
        dropoutVo.setDropRime(new Date());
        dropoutDao.insertSelective(dropoutVo);
        return dropoutVo;
    }

    @Override
    public int updateDrop(DropoutVo dropoutVo) {
        DropoutVo dropoutVo1 = new DropoutVo();
        BeanCopyUtil.copyProperties(dropoutVo,dropoutVo1);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo1);
    }

    @Override
    public int updateDropisPay1(Integer dropId) {
        DropoutVo dropoutVo1 = new DropoutVo();
        dropoutVo1.setIspay(1);
        dropoutVo1.setDropId(dropId);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo1);
    }

    @Override
    public int updateDropisPay2(Integer dropId) {
        DropoutVo dropoutVo1 = new DropoutVo();
        dropoutVo1.setIspay(2);
        dropoutVo1.setDropId(dropId);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo1);
    }

    @Override
    //审批
    public int updateDropJW_Approval1(Integer dropId) {
        //CourserecorddetailsVo courserecorddetailsVo = new CourserecorddetailsVo();
        DropoutVo dropoutVo1 = new DropoutVo();
        dropoutVo1.setJwApproval(1);
        dropoutVo1.setJwAppname("黑手");
        dropoutVo1.setJwApptime(new Date());
        dropoutVo1.setDropId(dropId);
        //courserecorddetailsVo.setLearningstate(6);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo1);
    }
    //已退学
//    @Override
//    public int updateLearningstate6(Integer courserecorddetailsId) {
//        CourserecorddetailsVo courserecorddetailsVo6 = new CourserecorddetailsVo();
//        courserecorddetailsVo6.setLearningstate(6);
//        courserecorddetailsVo6.setCourserecorddetailsId(courserecorddetailsId);
//
//        return courserecorddetailsDao.updateByPrimaryKeySelective(courserecorddetailsVo6);
//    }

    @Override
    //撤销审批
    public int updateDropJW_Approval0(Integer dropId) {
        DropoutVo dropoutVo1 = new DropoutVo();
        dropoutVo1.setJwApproval(0);
        dropoutVo1.setJwDropnameapp("楼子后悔");
        dropoutVo1.setJwDroptimeapp(new Date());
        dropoutVo1.setDropId(dropId);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo1);
    }

    @Override
    public int deleteDrop(Integer dropId) {
        log.debug("开始删除退学记录");
        DropoutVo dropoutVo = new DropoutVo();
        //删除人！！！
        dropoutVo.setDeletename("楼子");
        //删除时间！！！
        dropoutVo.setDeletetime(new Date());
        dropoutVo.setTimeliness(1);
        dropoutVo.setDropId(dropId);
        return dropoutDao.updateByPrimaryKeySelective(dropoutVo);
    }
}
