package com.trkj.tsm.dao;

import com.trkj.tsm.vo.FaqQuestions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqQuestionsDao {
    int deleteByPrimaryKey(Integer faqId);

    int insert(FaqQuestions record);

    int insertSelective(FaqQuestions record);

//    FaqQuestions selectByPrimaryKey(Integer faqId);

    int updateByPrimaryKeySelective(FaqQuestions record);

    int updateByPrimaryKey(FaqQuestions record);

    List<FaqQuestions> selectAll();
    List<FaqQuestions> selectAll1(String problem );
}