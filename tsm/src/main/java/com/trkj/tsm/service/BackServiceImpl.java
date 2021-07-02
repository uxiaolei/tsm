package com.trkj.tsm.service;

import com.trkj.tsm.dao.BackDao;
import com.trkj.tsm.entity.Back;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.BackVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BackServiceImpl implements BackService {
    @Resource
    private BackDao backDao;
    @Override
    public List<BackVo> selectAllBack() {
        return backDao.selectAllBack();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "backVo",key = "#backVo.getBackId()")})
    public BackVo addBack(BackVo backVo) {
        Back back = new Back();
        BeanCopyUtil.copyProperties(backVo,back);
        back.setBackTime(new Date());
        backDao.insertSelective(backVo);
        return backVo;
    }

    @Override
    public BackVo updateBack(BackVo backVo) {
        Back back = new Back();
        BeanCopyUtil.copyProperties(backVo,back);
        back.setUpdatetime(new Date());
        backDao.updateByPrimaryKeySelective(backVo);
        return backVo;
    }

    @Override
    public int updateBack_Approval(Integer backId) {
        BackVo backVo = new BackVo();
        backVo.setBackId(backId);
        backVo.setBackApproval(1);
        backVo.setBackBapptime(new Date());

        return backDao.updateByPrimaryKeySelective(backVo);
    }

    @Override
    public int deleteBack(Integer backId) {
        BackVo backVo = new BackVo();
        backVo.setDeletetime(new Date());
        return backDao.updateByPrimaryKeySelective(backVo);
    }
}
