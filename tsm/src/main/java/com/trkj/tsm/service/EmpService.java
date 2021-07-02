package com.trkj.tsm.service;

import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EmpVo;

import java.util.List;

public interface EmpService{
    Emp selectByPrimaryKey(Integer empId);
    List<Emp> selectAllEmp();
    EmpVo insertEmp(EmpVo emp);
    List<Emp> selAllEmpByroleid(Integer roleid);
    EmpVo goEmpState(EmpVo empVo);
    EmpVo updateEmp(EmpVo emp);
    int findempid(String username);
    List<Emp> selectAllEmp2(Integer deptid);
}
