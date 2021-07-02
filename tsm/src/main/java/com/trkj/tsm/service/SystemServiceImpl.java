package com.trkj.tsm.service;

import com.trkj.tsm.dao.SystemDao;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SystemVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SystemServiceImpl implements SystemService {
    @Resource
    private SystemDao systemDao;

    @Override
    public List<SystemVo> selectAllSystem() {
        return systemDao.selectAllSystem();
    }

    @Override
    public SystemVo insertSystem(SystemVo systemVo) {
        systemVo.setAddtime(new Date());
        systemDao.insertSystem(systemVo);
        return systemVo;
    }

    @Override
    public SystemVo updateSystemStateGo(SystemVo systemVo) {
        systemVo.setSystemState(1);
        systemVo.setPublishtime(new Date());
        systemDao.updateSystemStateGo(systemVo);
        return systemVo;
    }

    @Override
    public SystemVo updateSystemStateStop(SystemVo systemVo) {
        systemVo.setSystemState(2);
        systemVo.setSuspendtime(new Date());
        systemDao.updateSystemStateStop(systemVo);
        return systemVo;
    }

    @Override
    public SystemVo updateSystem(SystemVo systemVo) {
        systemVo.setUpdatetime(new Date());
        systemDao.updateSystem(systemVo);
        return systemVo;
    }

    @Override
    public SystemVo deleteSystem(SystemVo systemVo) {
        systemVo.setDeletetime(new Date());
        systemVo.setTimeliness(1);
        systemDao.deleteSystem(systemVo);
        return systemVo;
    }

    @Override
    public List<SystemVo> selectSystemByStateYES() {
        return systemDao.selectSystemByStateYES();
    }

    @Override
    public List<SystemVo> selectSystemByStateNO() {
        return systemDao.selectSystemByStateNO();
    }

    @Override
    public AjaxResponse deleteSystemMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s: id) {
            SystemVo systemVo=new SystemVo();
            systemVo.setDeletetime(new Date());
            systemVo.setDeletename(updatename);
            systemVo.setTimeliness(1);
            systemVo.setSystemId(Integer.parseInt(s));
            systemDao.deleteSystem(systemVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public AjaxResponse updateSystemStateStopMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s:id){
            SystemVo systemVo=new SystemVo();
            systemVo.setSuspendtime(new Date());
            systemVo.setSystemState(2);
            systemVo.setSuspendname(updatename);
            systemVo.setSystemId(Integer.parseInt(s));
            systemDao.updateSystemStateStop(systemVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public AjaxResponse updateSystemStateGoMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s:id){
            SystemVo systemVo=new SystemVo();
            systemVo.setPublishtime(new Date());
            systemVo.setSystemState(1);
            systemVo.setPublishname(updatename);
            systemVo.setSystemId(Integer.parseInt(s));
            systemDao.updateSystemStateGo(systemVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public List<SystemVo> selectSystemByDept(String deptname) {
        return systemDao.selectSystemByDept(deptname);
    }

    @Override
    public List<SystemVo> selectSystemByTheme(String systemtheme) {
        return systemDao.selectSystemByTheme(systemtheme);
    }

    @Override
    public List<SystemVo> selectSystemByType(String systemtype) {
        return systemDao.selectSystemByType(systemtype);
    }

}
