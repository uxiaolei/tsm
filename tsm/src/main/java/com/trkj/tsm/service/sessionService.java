package com.trkj.tsm.service;

import com.trkj.tsm.vo.Session;

import java.util.List;

public interface sessionService {
    List<Session> selectByPrimaryKey();
    Session insertsession(Session session);
    Session updateByPrimaryKey(Session session);
    Session deleteByPrimaryKey(Session session);
}
