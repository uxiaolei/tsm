package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;

import java.util.List;

public interface SystemSelectService {
    AjaxResponse insertSystem(Integer systemId, String deptId);
    List<Integer> selectEmpIdBySystemId(Integer systemId);
}
