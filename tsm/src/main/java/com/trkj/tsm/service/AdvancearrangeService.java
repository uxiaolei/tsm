package com.trkj.tsm.service;

import com.trkj.tsm.vo.AdvancearrangeVo;

import java.util.List;

public interface AdvancearrangeService {
    int addAdvancearrange(AdvancearrangeVo record);
    List<AdvancearrangeVo> selectAllAdvancearrange();
    int updateByAdvancearrangeKey(AdvancearrangeVo record);
    int clearArrange();
    void appArrange(List<AdvancearrangeVo> arrangeFormVoList);
}
