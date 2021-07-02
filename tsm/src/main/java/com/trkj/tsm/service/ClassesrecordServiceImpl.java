package com.trkj.tsm.service;

import com.trkj.tsm.dao.ClassesrecordDao;
import com.trkj.tsm.entity.Classesrecord;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.ClassesrecordVo;
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
public class ClassesrecordServiceImpl implements ClassesrecordService {
    @Resource
    private ClassesrecordDao classesrecordDao;
    @Override
    public List<ClassesrecordVo> selectAllClassesRecord() {
        return classesrecordDao.selectAllClassesRecord();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "classesrecord",key = "#classesrecordVo.getClassesrecordId()")})//获取表名，vo类的id
    public ClassesrecordVo addClassesrecord(ClassesrecordVo classesrecordVo) {
        log.debug("新增报班记录");
        Classesrecord c=new Classesrecord();
        classesrecordVo.setAddname("楼子");
        BeanCopyUtil.copyProperties(classesrecordVo,c);
        classesrecordDao.insertSelective(classesrecordVo);
        return classesrecordVo;
    }

    @Override
    public int updateClassesrecord(ClassesrecordVo classesrecordVo) {
        ClassesrecordVo classesrecordVo1 = new ClassesrecordVo();
        BeanCopyUtil.copyProperties(classesrecordVo,classesrecordVo1);
        classesrecordVo1.setUpdatename("楼子");
        classesrecordVo1.setUpdatetime(new Date());
        return classesrecordDao.updateByPrimaryKeySelective(classesrecordVo1);
    }

    @Override
    public int deleteClassesrecord(Integer classesrecordId) {
        log.debug("开始删除报班记录");
        ClassesrecordVo vo = new ClassesrecordVo();
        vo.setClassesrecordId(classesrecordId);
        vo.setDeletename("李云龙");
        vo.setDeletetime(new Date());
        vo.setTimeliness(1);
        return classesrecordDao.updateByPrimaryKeySelective(vo);
    }
}
