package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.IdeasVo;

import java.util.List;

public interface IdeasService {
    List<IdeasVo> selectAllIdeas();
    List<IdeasVo> selectIdeasBySuggest(Integer suggestId, int currentPage, int pagesize);
    List<IdeasVo> selectIdeasBySuggestAndState(Integer suggestId,Integer state,int currentPage,int pagesize);
    List<IdeasVo> selectIdeasByEmpIdAndState(Integer empId,Integer state);
    List<IdeasVo> selectIdeasByEmpId(Integer empId);
    List<IdeasVo> selectIdeasBySuggestAndEmpName(Integer suggestId,String empName,int currentPage,int pagesize);
    List<IdeasVo> selectIdeasBySuggestAndTitle(Integer suggestId,String ideasTitle,int currentPage,int pagesize);
    List<IdeasVo> selectIdeasBySuggestAndReply(Integer suggestId,String reply,int currentPage,int pagesize);
    List<IdeasVo> selectIdeasByEmpIdAndEmpName(Integer empId,String empName);
    List<IdeasVo> selectIdeasByEmpIdAndTitle(Integer empId,String ideasTitle);
    List<IdeasVo> selectIdeasByEmpIdAndReply(Integer empId,String reply);
    IdeasVo insertIdeas(IdeasVo ideasVo);
    IdeasVo replyIdeas(IdeasVo ideasVo);
    IdeasVo deleteIdeas(IdeasVo ideasVo);
    IdeasVo noLookIdeas(IdeasVo ideasVo);
    AjaxResponse deleteIdeasMany(String ids,String name);
    AjaxResponse noLookIdeasMany(String ids);
    List<IdeasVo> selectAllIdeasByEmpName(String empname);
    List<IdeasVo> selectAllIdeasByTitle(String title);
    List<IdeasVo> selectAllIdeasByState(Integer state);
    List<IdeasVo> selectAllIdeasBySuggestName(String suggestname);
}
