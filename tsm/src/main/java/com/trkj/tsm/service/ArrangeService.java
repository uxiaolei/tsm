package com.trkj.tsm.service;

import com.trkj.tsm.vo.ArrangeVo;

import java.util.List;

public interface ArrangeService {
    int deleteByArrangeKey(Integer arrangeId);

    int addArrange(ArrangeVo record);

    List<ArrangeVo> selectAllArranges();

    int insertSelective(ArrangeVo record);

    ArrangeVo selectByArrangeKey(Integer arrangeId);

    int updateByArrangeKeySelective(ArrangeVo record);

    int updateByArrangeKey(ArrangeVo record);
}
