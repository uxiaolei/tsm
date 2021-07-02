package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Suggest;
import com.trkj.tsm.vo.SuggestVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuggestDao {
    int deleteByPrimaryKey(Integer suggestId);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    Suggest selectByPrimaryKey(Integer suggestId);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);

    /**
     * 查询所有意见箱
     * @return
     */
    List<SuggestVo> selectAllSuggest();

    /**
     * 查询所有可用的意见箱
     *
     */
    List<SuggestVo> selectAllSuggestByState();

    /**
     * 根据部门id查询
     * @param deptId
     * @return
     */
    Suggest selectSuggestByDeptId(Integer deptId);

    /**
     * 根据条件模糊查询：意见箱名称、部门名称
     * @param suggestName
     * @return
     */
    List<SuggestVo> selectSuggestByName(String suggestName);
    List<SuggestVo> selectSuggestByDept(String deptName);

    /**
     * 添加意见箱
     * @param suggestVo
     * @return
     */
    int insertSuggest(SuggestVo suggestVo);

    /**
     * 修改意见箱信息
     * @param suggestVo
     * @return
     */
    int updateSuggest(SuggestVo suggestVo);

    /**
     * 删除意见箱
     * @param suggestVo
     * @return
     */
    int deleteSuggest(SuggestVo suggestVo);

    /**
     * 修改意见箱状态
     */
    int updateSuggestState(SuggestVo suggestVo);
}