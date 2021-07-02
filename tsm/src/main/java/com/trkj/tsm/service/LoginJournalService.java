package com.trkj.tsm.service;

import com.trkj.tsm.vo.LoginjournalVo;

import java.util.List;

public interface LoginJournalService {
    LoginjournalVo setLoginJlogin(LoginjournalVo loginjournalVo);

    List<LoginjournalVo> selectAllLoginJ();

    List<LoginjournalVo> selectLoginJByEmp(String empName);

    List<LoginjournalVo> selectLoginJByLoginTime(String logintime);

    List<LoginjournalVo> selectLoginJByLoginTimeAndEmp(String time,String what);
}
