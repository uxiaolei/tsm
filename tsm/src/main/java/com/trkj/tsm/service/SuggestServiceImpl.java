package com.trkj.tsm.service;

import com.trkj.tsm.dao.SuggestDao;
import com.trkj.tsm.entity.Suggest;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.SuggestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SuggestServiceImpl implements SuggestService {
    @Resource
    private SuggestDao suggestDao;

    @Override
    public List<SuggestVo> selectAllSuggest() {
        return suggestDao.selectAllSuggest();
    }

    @Override
    public List<SuggestVo> selectAllSuggestByState() {
        return suggestDao.selectAllSuggestByState();
    }

    @Override
    public List<SuggestVo> selectSuggestByName(String suggestName) {
        return suggestDao.selectSuggestByName(suggestName);
    }

    @Override
    public List<SuggestVo> selectSuggestByDept(String deptName) {
        return suggestDao.selectSuggestByDept(deptName);
    }

    @Override
    public SuggestVo insertSuggest(SuggestVo suggestVo) {
        suggestVo.setAddtime(new Date());
        suggestDao.insertSuggest(suggestVo);
        return suggestVo;
    }

    @Override
    public SuggestVo updateSuggest(SuggestVo suggestVo) {
        suggestVo.setUpdatetime(new Date());
        suggestDao.updateSuggest(suggestVo);
        return suggestVo;
    }

    @Override
    public SuggestVo deleteSuggest(SuggestVo suggestVo) {
        suggestVo.setDeletetime(new Date());
        suggestVo.setTimeliness(1);
        suggestDao.deleteSuggest(suggestVo);
        return suggestVo;
    }

    @Override
    public AjaxResponse deleteSuggestMany(String ids,String name) {
        String[] id = ids.split(",");
        for (String s : id) {
            SuggestVo suggestVo = new SuggestVo();
            suggestVo.setDeletename(name);
            suggestVo.setDeletetime(new Date());
            suggestVo.setTimeliness(1);
            suggestVo.setSuggestId(Integer.parseInt(s));
            suggestDao.deleteSuggest(suggestVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public Suggest selectSuggestByDeptId(Integer deptId) {
        return suggestDao.selectSuggestByDeptId(deptId);
    }

    @Override
    public AjaxResponse updateSuggestState1(SuggestVo suggestVo) {
        suggestVo.setUpdatetime(new Date());
        suggestVo.setSuggestState(1);
        suggestDao.updateSuggestState(suggestVo);
        return AjaxResponse.success(suggestVo);
    }

    @Override
    public AjaxResponse updateSuggestState2(SuggestVo suggestVo) {
        suggestVo.setUpdatetime(new Date());
        suggestVo.setSuggestState(0);
        suggestDao.updateSuggestState(suggestVo);
        return AjaxResponse.success(suggestVo);
    }
}
