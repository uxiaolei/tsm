package com.trkj.tsm.service;

import com.trkj.tsm.dao.ArrangeDao;
import com.trkj.tsm.service.ArrangeService;
import com.trkj.tsm.vo.ArrangeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArrangeServiceImpl implements ArrangeService {
    @Resource
    private ArrangeDao arrangeDao;
    @Override
    @Transactional
    public int deleteByArrangeKey(Integer arrangeId) {
        return 0;
    }

    @Override
    @Transactional
    public int addArrange(ArrangeVo record) {
        return arrangeDao.addArrange(record);
    }

    @Override
    public List<ArrangeVo> selectAllArranges() {
        return null;
    }

    @Override
    @Transactional
    public int insertSelective(ArrangeVo record) {
        return arrangeDao.insertSelective(record);
    }

    @Override
    public ArrangeVo selectByArrangeKey(Integer arrangeId) {
        return null;
    }

    @Override
    @Transactional
    public int updateByArrangeKeySelective(ArrangeVo record) {
        return 0;
    }

    @Override
    @Transactional
    public int updateByArrangeKey(ArrangeVo record) {
        return 0;
    }
}
