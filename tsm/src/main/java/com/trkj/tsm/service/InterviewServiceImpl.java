package com.trkj.tsm.service;

import com.trkj.tsm.dao.InterviewDao;
import com.trkj.tsm.entity.Interview;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.InterviewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    @Override
    public List<Interview> selAllInterview(Integer studentId) {
        return interviewDao.selAllInterview(studentId);
    }

    @Override
    public Interview addinterview(Interview interview) {
        InterviewVo interviewVo = new InterviewVo();
        interview.setInterviewTime(new Date());
        BeanCopyUtil.copyProperties(interview, interviewVo);
        interviewDao.insertSelective(interview);
        return interview;
    }

    @Override
    public int delinterview(Interview interview) {
        interview.setDeletetime(new Date());
        return interviewDao.updateByPrimaryKeySelective(interview);
    }
}
