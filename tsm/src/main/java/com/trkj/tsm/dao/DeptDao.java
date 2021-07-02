package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Dept;
import com.trkj.tsm.vo.DeptVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    /**
     * 查询所有部门
     * @return
     */
    List<DeptVo> selectAllDept();

    /**
     * 添加部门
     * @param deptVo
     * @return
     */
    int insertDept(DeptVo deptVo);

    /**
     * 修改部门
     * @param deptVo
     * @return
     */
    int updateDept(DeptVo deptVo);

    /**
     * 删除部门
     * @param deptVo
     * @return
     */
    int deleteDept(DeptVo deptVo);

    /**
     * 根据部门名称、序列号进行模糊查询
     * @param deptName
     * @return
     */
    List<DeptVo> selectDeptByName(String deptName);
    List<DeptVo> selectDeptBySortnumber(String deptSortnumber);
}