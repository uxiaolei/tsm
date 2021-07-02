package com.trkj.tsm.service;

import com.trkj.tsm.dao.DeptDao;
import com.trkj.tsm.entity.Dept;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.DeptVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public List<DeptVo> selectAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptId) {
        return deptDao.selectByPrimaryKey(deptId);
    }

    @Override
    public DeptVo insertDept(DeptVo deptVo) {
        List<DeptVo> deptlist=deptDao.selectAllDept();
        int deptsn=100+deptlist.size()+1;
        deptVo.setAddname("梁政");
        deptVo.setAddtime(new Date());
        deptVo.setDeptSortnumber(String.valueOf(deptsn));
        deptDao.insertDept(deptVo);
        return deptVo;
    }

    @Override
    public DeptVo updateDept(DeptVo deptVo) {
        deptVo.setUpdatename("梁政");
        deptVo.setUpdatetime(new Date());
        deptDao.updateDept(deptVo);
        return deptVo;
    }

    @Override
    public DeptVo deleteDept(DeptVo deptVo) {
        deptVo.setDeletename("梁政");
        deptVo.setDeletetime(new Date());
        deptDao.deleteDept(deptVo);
        return deptVo;
    }

    @Override
    public List<DeptVo> selectDeptByName(String deptName) {
        return deptDao.selectDeptByName(deptName);
    }

    @Override
    public List<DeptVo> selectDeptBySortnumber(String deptSortnumber) {
        return deptDao.selectDeptBySortnumber(deptSortnumber);
    }

    @Override
    public AjaxResponse deleteDeptMany(String ids) {
        String[] id = ids.split(",");
        for(String s : id){
            DeptVo deptVo=new DeptVo();
            deptVo.setDeletetime(new Date());
            deptVo.setDeletename("梁政");
            deptVo.setTimeliness(1);
            deptVo.setDeptId(Integer.parseInt(s));
            deptDao.deleteDept(deptVo);
        }
        return AjaxResponse.success();
    }

}
