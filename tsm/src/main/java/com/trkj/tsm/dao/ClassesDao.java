package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.vo.ClassesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClassesDao {
    int deleteByPrimaryKey(Integer classesId);

    int insert(ClassesVo record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classesId);

    int updateByPrimaryKeySelective(ClassesVo record);

    int updateByPrimaryKey(ClassesVo record);

    List<ClassesVo> selectAll();

    List<ClassesVo> selectreclassesMH(String flag);//模糊查询

    List<ClassesVo> selClasses2(int courseId);

    int updateCoursedetailsIdByClassesId(Classes classes);

    Classes selectreclassesbyClasses_Name(String falg);

}