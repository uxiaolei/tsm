package com.trkj.tsm.vo;

import java.util.Date;
import lombok.Data;

/**
 * faq_questions
 * @author 
 */
@Data
public class FaqQuestions  {
    /**
     * FAQ编号
     */
    private Integer faqId;

    /**
     * 问题
     */
    private String problem;

    /**
     * 回答
     */
    private String answer;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加的时间
     */
    private Date addtime;

    /**
     * 最后修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 点击量
     */
    private Integer clickcount;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}