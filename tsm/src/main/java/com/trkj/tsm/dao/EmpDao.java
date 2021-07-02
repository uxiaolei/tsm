package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.vo.EmpVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpDao {
    int deleteByPrimaryKey(Integer empId);

    int insert(Emp record);

    int insertSelective(EmpVo record);

    Emp selectByPrimaryKey(Integer empId);

    List<Emp> selectAllEmp();

    List<Emp> selectByDeptId(Integer deptId);

    int updateByPrimaryKeySelective(EmpVo emp);

    int updateByPrimaryKeySelective2(EmpVo emp);

    int updateByPrimaryKey(Emp record);

    Emp findByUsername(String username);

    List<Emp> selectEmpIdByDeptId(Integer deptid);

    List<Emp> selctEmpByroleId(Integer roleid);

    int selEmpIdByusername(String username);
}