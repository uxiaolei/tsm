package com.trkj.tsm.service;

import com.trkj.tsm.dao.ClasstypeDao;
import com.trkj.tsm.entity.Classtype;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.ClasstypeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ClasstypeServiceImpl implements ClasstypeService {
    @Resource
    private ClasstypeDao classtypeDao;

    private ClasstypeService classtypeService;
    @Override
    public List<ClasstypeVo> selectClasstypes() {

        return classtypeDao.selectClasstypes();
    }

    @Override
    public Classtype addClasstypes(Classtype classtype) {
        //log.debug("开始增加");
        classtype.setAddname("Admin");
        classtypeDao.insert(classtype);
        return classtype;
    }

    @Override
    public int updateClasstypes(ClasstypeVo classtypeVo) {
        log.debug("开始修改信息");
        ClasstypeVo classtype = new ClasstypeVo();
        BeanCopyUtil.copyProperties(classtypeVo,classtype);
        classtypeVo.setDeletename("楼子");
        classtypeVo.setDeletetime(new Date());
        return classtypeDao.updateByPrimaryKeySelective(classtype);
    }

    @Override
    public int deleteByClasstypesId(Integer classtypeId) {
        log.debug("开始删除信息");
        ClasstypeVo classtypeVo = new ClasstypeVo();
        classtypeVo.setClasstypeId(classtypeId);
        classtypeVo.setDeletename("楼子");
        classtypeVo.setDeletetime(new Date());
        classtypeVo.setTimeliness(1);
        return classtypeDao.updateByPrimaryKeySelective(classtypeVo);
    }
}
