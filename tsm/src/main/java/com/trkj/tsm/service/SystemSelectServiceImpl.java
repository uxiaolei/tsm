package com.trkj.tsm.service;

import com.trkj.tsm.dao.EmpDao;
import com.trkj.tsm.dao.SystemselectDao;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.entity.Systemselect;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SystemselectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SystemSelectServiceImpl implements SystemSelectService {
    @Resource
    private SystemselectDao systemselectDao;
    @Resource
    private EmpDao empDao;

    @Override
    public AjaxResponse insertSystem(Integer systemId, String deptId) {
        String[] deptIds=deptId.split(",");
        for (String did:deptIds){
            List<Emp> empIds=empDao.selectEmpIdByDeptId(Integer.parseInt(did));
            for (Emp eid:empIds){
                SystemselectVo systemselectVo=new SystemselectVo();
                Integer empid=eid.getEmpId();
                systemselectVo.setEmpId(empid);
                systemselectVo.setSystemId(systemId);
                systemselectDao.insertSystem(systemselectVo);
            }
        }
        return AjaxResponse.success();
    }

    @Override
    public List<Integer> selectEmpIdBySystemId(Integer systemId) {
        //根据制度id得到所有制度允许查看表的信息
        List<Systemselect> systemselectList=systemselectDao.selectEmpIdBySystemId(systemId);
        List<Integer> empids=new ArrayList<>();
        for(int i=0;i<systemselectList.size();i++){
            //根据下标得到制度允许查看表的信息
            Systemselect systemselect=systemselectList.get(i);
            //从制度允许查看表中得到empId
            Integer empid=systemselect.getEmpId();
            //将得到的empId放到集合中
            empids.add(empid);
        }
        return empids;
    }
}
