package com.trkj.tsm.service;

import com.trkj.tsm.dao.SessionDao;
import com.trkj.tsm.vo.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class sessionServiceImpl implements sessionService {
    @Resource
    private SessionDao sessionDao;

    @Override
    public List<Session>selectByPrimaryKey(){
        return sessionDao.selectByPrimaryKey();

    }
    @Override
    public Session insertsession(Session session){

         sessionDao.insertsession(session);
        return session;
    }
    @Override
    public Session updateByPrimaryKey(Session session){
        sessionDao.updateByPrimaryKeySelective(session);
        return session;
    }
    @Override
    public Session deleteByPrimaryKey(Session session){
        session.setTimeliness(1);
        session.setDeletetime(new Date());
        sessionDao.updateByPrimaryKeySelective(session);
        return session;
    }
}
