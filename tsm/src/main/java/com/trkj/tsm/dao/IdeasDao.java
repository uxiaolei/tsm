package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Ideas;
import com.trkj.tsm.vo.IdeasVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdeasDao {
    int deleteByPrimaryKey(Integer ideasId);

    int insert(Ideas record);

    int insertSelective(Ideas record);

    Ideas selectByPrimaryKey(Integer ideasId);

    int updateByPrimaryKeySelective(Ideas record);

    int updateByPrimaryKey(Ideas record);

    /**
     * 查询所有意见
     */
    List<IdeasVo> selectAllIdeas();

    /**
     * 根据条件模糊查询所有意见：发布人、标题、状态、意见箱
     * @param empname
     * @return
     */
    List<IdeasVo> selectAllIdeasByEmpName(String empname);
    List<IdeasVo> selectAllIdeasByTitle(String title);
    List<IdeasVo> selectAllIdeasByState(Integer state);
    List<IdeasVo> selectAllIdeasBySuggestName(String suggestname);

    /**
     * 根据意见箱查询
     * @param suggestId
     * @return
     */
    List<IdeasVo> selectIdeasBySuggest(Integer suggestId);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    List<IdeasVo> selectIdeasBySuggestAndState(Integer suggestId,Integer state);
    List<IdeasVo> selectIdeasByEmpIdAndState(Integer empId,Integer state);

    /**
     * 根据发布人查询
     * @param empId
     * @return
     */
    List<IdeasVo> selectIdeasByEmpId(Integer empId);

    /**
     * 根据条件模糊查询收到意见：发布人、意见标题、回复人
     * @param
     * @return
     */
    List<IdeasVo> selectIdeasBySuggestAndEmpName(Integer suggestId,String empName);
    List<IdeasVo> selectIdeasBySuggestAndTitle(Integer suggestId,String ideasTitle);
    List<IdeasVo> selectIdeasBySuggestAndReply(Integer suggestId,String reply);

    /**
     * 根据条件模糊查询发出意见：发布人、意见标题、回复人
     * @param
     * @return
     */
    List<IdeasVo> selectIdeasByEmpIdAndEmpName(Integer empId,String empName);
    List<IdeasVo> selectIdeasByEmpIdAndTitle(Integer empId,String ideasTitle);
    List<IdeasVo> selectIdeasByEmpIdAndReply(Integer empId,String reply);

    /**
     * 添加意见
     * @param ideasVo
     * @return
     */
    int insertIdeas(IdeasVo ideasVo);

    /**
     * 回复意见
     * @param ideasVo
     * @return
     */
    int replyIdeas(IdeasVo ideasVo);

    /**
     * 删除意见
     * @param ideasVo
     * @return
     */
    int deleteIdeas(IdeasVo ideasVo);

    int noLookIdeas(IdeasVo ideasVo);
}