package com.trkj.tsm.service;

import com.trkj.tsm.dao.EmpDao;
import com.trkj.tsm.entity.Dept;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EmpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;
    @Resource
    private DeptService deptService;

    @Override
    public Emp selectByPrimaryKey(Integer empId) {
        return empDao.selectByPrimaryKey(empId);
    }

    @Override
    public List<Emp> selectAllEmp() {
        List<Emp> empList= empDao.selectAllEmp();
        return empList;
    }

    @Override
    public EmpVo insertEmp(EmpVo emp) {
        emp.setAddname("梁政");
        emp.setAddtime(new Date());
        log.debug("--------------");
        log.debug(emp.toString());
        emp.setPassword("$10$xPNoI0sBxOY6Y5Nj1bF6iO6OePqJ8tAJUsD5x5wh6G1BPphhSLcae");
        emp.setEnabled(true);
        //通过部门编号得到此部门的职工数据
        List<Emp> list = empDao.selectByDeptId(emp.getDeptId());
        //得到此部门的职工人数并+1
        int listsize = list.size() + 1;
        //通过部门编号得到此部门的部门序列号
        Dept dept = deptService.selectByPrimaryKey(emp.getDeptId());
        String deptSN = dept.getDeptSortnumber();
        //工号=部门序列号+职工人数
        emp.setJobnumber(deptSN + listsize);
        empDao.insertSelective(emp);
        return emp;
    }

    @Override
    public List<Emp> selAllEmpByroleid(Integer roleid) {
        return empDao.selctEmpByroleId(roleid);
    }

    @Override
    public EmpVo goEmpState(EmpVo empVo) {
        empVo.setUpdatetime(new Date());
        empDao.updateByPrimaryKeySelective2(empVo);
        return empVo;
    }

    @Override
    public EmpVo updateEmp(EmpVo emp) {
        emp.setUpdatename("梁政");
        emp.setUpdatetime(new Date());
        log.debug("+++++++++++++++++++++++++++++++++++++");
        log.debug(emp.toString());
        empDao.updateByPrimaryKeySelective(emp);
        return emp;
    }

    @Override
    public int findempid(String username) {
        return empDao.selEmpIdByusername(username);
    }

    @Override
    public List<Emp> selectAllEmp2(Integer deptid) {
        return empDao.selectByDeptId(deptid);
    }

}
