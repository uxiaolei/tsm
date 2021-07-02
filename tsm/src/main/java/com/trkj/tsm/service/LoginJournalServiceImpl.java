package com.trkj.tsm.service;

import com.trkj.tsm.dao.LoginjournalDao;
import com.trkj.tsm.vo.LoginjournalVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class LoginJournalServiceImpl implements LoginJournalService {
    @Resource
    private LoginjournalDao loginjournalDao;
    @Override
    public LoginjournalVo setLoginJlogin(LoginjournalVo loginjournalVo) {
        loginjournalVo.setLogintime(new Date());
        loginjournalDao.insertLoginJlogin(loginjournalVo);
        return loginjournalVo;
    }

    @Override
    public List<LoginjournalVo> selectAllLoginJ() {
        return loginjournalDao.selectAllLoginJ();
    }

    @Override
    public List<LoginjournalVo> selectLoginJByEmp(String empName) {
        return loginjournalDao.selectLoginJByEmp(empName);
    }

    @Override
    public List<LoginjournalVo> selectLoginJByLoginTime(String logintime) {
        return loginjournalDao.selectLoginJByLoginTime(logintime);
    }

    @Override
    public List<LoginjournalVo> selectLoginJByLoginTimeAndEmp(String time, String what) {
        return loginjournalDao.selectLoginJByLoginTimeAndEmp(time,what);
    }
}
