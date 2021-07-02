package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SystemVo;

import java.util.List;

public interface SystemService {
    List<SystemVo> selectAllSystem();
    SystemVo insertSystem(SystemVo systemVo);
    SystemVo updateSystemStateGo(SystemVo systemVo);
    SystemVo updateSystemStateStop(SystemVo systemVo);
    SystemVo updateSystem(SystemVo systemVo);
    SystemVo deleteSystem(SystemVo systemVo);
    List<SystemVo> selectSystemByStateYES();
    List<SystemVo> selectSystemByStateNO();
    AjaxResponse deleteSystemMany(String ids,String updatename);
    AjaxResponse updateSystemStateStopMany(String ids,String updatename);
    AjaxResponse updateSystemStateGoMany(String ids,String updatename);
    List<SystemVo> selectSystemByDept(String deptname);
    List<SystemVo> selectSystemByTheme(String systemtheme);
    List<SystemVo> selectSystemByType(String systemtype);
}
