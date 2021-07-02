package com.trkj.tsm.service;

import com.trkj.tsm.entity.Suggest;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SuggestVo;

import java.util.List;

public interface SuggestService {

    List<SuggestVo> selectAllSuggest();
    List<SuggestVo> selectAllSuggestByState();
    List<SuggestVo> selectSuggestByName(String suggestName);
    List<SuggestVo> selectSuggestByDept(String deptName);
    SuggestVo insertSuggest(SuggestVo suggestVo);
    SuggestVo updateSuggest(SuggestVo suggestVo);
    SuggestVo deleteSuggest(SuggestVo suggestVo);
    AjaxResponse deleteSuggestMany(String ids,String name);
    Suggest selectSuggestByDeptId(Integer deptId);
    /**
     * 停用
     * @param suggestVo
     * @return
     */
    AjaxResponse updateSuggestState1(SuggestVo suggestVo);

    /**
     * 启用
     * @param suggestVo
     * @return
     */
    AjaxResponse updateSuggestState2(SuggestVo suggestVo);
}
