package com.trkj.tsm.service;

import com.trkj.tsm.entity.Dept;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.DeptVo;

import java.util.List;

public interface DeptService {
    List<DeptVo> selectAllDept();
    Dept selectByPrimaryKey(Integer deptId);
    DeptVo insertDept(DeptVo deptVo);
    DeptVo updateDept(DeptVo deptVo);
    DeptVo deleteDept(DeptVo deptVo);
    List<DeptVo> selectDeptByName(String deptName);
    List<DeptVo> selectDeptBySortnumber(String deptSortnumber);
    AjaxResponse deleteDeptMany(String ids);
}
