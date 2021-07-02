package com.trkj.tsm.service;


import com.trkj.tsm.entity.Interview;

import java.util.List;

public interface InterviewService {
    List<Interview> selAllInterview(Integer studentId);//查询所有
    Interview addinterview(Interview interview);//新增访谈记录
    int delinterview(Interview interview);//删除访谈记录
}
