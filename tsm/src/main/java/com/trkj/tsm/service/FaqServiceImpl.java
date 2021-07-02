package com.trkj.tsm.service;

import com.trkj.tsm.dao.FaqQuestionsDao;
import com.trkj.tsm.vo.FaqQuestions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
public class FaqServiceImpl implements FaqService {
    @Resource
    private FaqQuestionsDao faqQuestionsDao;

    @Override
    public List<FaqQuestions> selectAll() {

        return faqQuestionsDao.selectAll();
    }

    @Override
    public List<FaqQuestions> selectAll1(String value) {
        return faqQuestionsDao.selectAll1(value);
    }

    @Override
    public FaqQuestions insert(FaqQuestions faqQuestions){
        log.debug(faqQuestions.toString());
        faqQuestionsDao.insertSelective(faqQuestions);
        return faqQuestions;
    }
}
