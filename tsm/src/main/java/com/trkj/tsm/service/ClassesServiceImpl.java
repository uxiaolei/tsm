package com.trkj.tsm.service;

import com.trkj.tsm.dao.ClassesDao;
import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.ClassesVo;
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
public class ClassesServiceImpl implements ClassesService {

    @Resource
    private ClassesDao classesDao;

    @Override
    public List<ClassesVo> selectAll() {
        log.debug("-----------------------------------");
        log.debug(classesDao.selectAll().toString());
        return classesDao.selectAll();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "classes",key = "#classesVo.getClassesId()")})//获取表名，vo类的id
    public ClassesVo addClasses(ClassesVo classesVo) {
        log.debug("新增班级");
        Classes classes = new Classes();
       // classesVo.setAddname("楼子");
        BeanCopyUtil.copyProperties(classesVo,classes);
//        classes.setCourseId(classes.getCourse().getCourseId());
//        classes.setEmpId(classes.getEmp().getEmpId());
//        classes.setEmpId(classes.getEmp2().getEmpId());
        classesDao.insertSelective(classes);
        return classesVo;
    }

    @Override
    public int updateClasses(ClassesVo classesVo) {
        log.debug("修改班级");
        ClassesVo classes = new ClassesVo();
        BeanCopyUtil.copyProperties(classesVo,classes);
        //classesVo.setUpdatename("楼子");
        classesVo.setUpdatetime(new Date());
        return classesDao.updateByPrimaryKeySelective(classes);
    }

    @Override
    public ClassesVo deleteClasses(ClassesVo classesVo) {
        log.debug("开始删除信息");
        classesVo.setDeletetime(new Date());
        classesVo.setTimeliness(1);
        classesDao.updateByPrimaryKeySelective(classesVo);
        return classesVo;
    }

    @Override
    public int updateClassesOpen1(Integer classesId) {
      ClassesVo classesVo = new ClassesVo();
      classesVo.setClassesId(classesId);
      classesVo.setClassesOpen(1);
      return classesDao.updateByPrimaryKeySelective(classesVo);
    }

    @Override
    public int updateClassesOpen0(Integer classesId) {
        ClassesVo classesVo = new ClassesVo();
        classesVo.setClassesId(classesId);
        classesVo.setClassesOpen(0);
        return classesDao.updateByPrimaryKeySelective(classesVo);
    }

    @Override
    public List<ClassesVo> selectreclassesMH(String flag) {
        return classesDao.selectreclassesMH(flag);
    }

    @Override
    public List<ClassesVo> selClasses2(int courseId) {
        return classesDao.selClasses2(courseId);
    }

    @Override
    public Classes queryById(int classid) {
        return classesDao.selectByPrimaryKey(classid);
    }
}
