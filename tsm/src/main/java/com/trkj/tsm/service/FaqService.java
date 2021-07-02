package com.trkj.tsm.service;

import com.trkj.tsm.vo.FaqQuestions;

import java.util.List;

public interface FaqService {
    List<FaqQuestions> selectAll();
    List<FaqQuestions> selectAll1(String value );
    FaqQuestions insert(FaqQuestions faqQuestions);
}
