package com.trkj.tsm.service;

import com.trkj.tsm.dao.StudentDao;
import com.trkj.tsm.entity.Course;
import com.trkj.tsm.entity.Student;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.StudentVo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 根据学生姓名查询
     * @param flag
     * @return
     */
    @Override
    public List<StudentVo> selStudent(String flag) {
        return studentDao.selectBystudentName(flag);
    }

    /**
     * 新增学员
     * @param studentVo
     * @return
     */
    @Override
    public StudentVo addStudent(StudentVo studentVo) {
        studentDao.insertSelective(studentVo);
        return studentVo;
    }

    /**
     * 修改学员
     * @param studentVo
     * @return
     */
    @Override
    public int updateStudent(StudentVo studentVo) {
        Student student=new Student();
        BeanCopyUtil.copyProperties(studentVo,student);
        student.setUpdatetime(new Date());
        student.setUpdatename("updat");
        student.setClassesId(1);
        student.setRegisterId(1);
        student.setSourceId(1);
        return  studentDao.updateByPrimaryKeySelective(student) ;
    }

    /**
     * 删除学员
     * @param studentVo
     * @return
     */
    @Override
    public int deleteStudnet(StudentVo studentVo) {
        Student student=new Student();
        BeanCopyUtil.copyProperties(studentVo,student);
        student.setDeletename("delte");
        student.setDeletetime(new Date());
        student.setTimeliness(1);
        student.setClassesId(1);
        student.setRegisterId(1);
        student.setSourceId(1);
        return  studentDao.updateByPrimaryKeySelective(student) ;
    }

    /**
     * 查询学员外键无分页
     * @param flag
     * @return
     */
    @Override
    public List<StudentVo> selwjStudent(String flag) {
        return studentDao.selectBystudentName(flag);
    }

    @Override
    public List<StudentVo> seleSourceId(Integer sourceId) {
        return studentDao.seleSourceId(sourceId);//根据生源渠道id显示该生源渠道下的学员信息
    }

    @Override
    public List<StudentVo> selectAllpage() {
        return studentDao.selectAllpage();
    }
}
