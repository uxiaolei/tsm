package com.trkj.tsm.service;

import com.trkj.tsm.vo.SourceVo;

import java.util.List;

public interface SourceService {
    SourceVo addSource(SourceVo sourceVo);//新增
    int deleteSource(Integer sourceId);//删除
    SourceVo updateSource(SourceVo sourceVo);//修改
    List<SourceVo> conditionselect(String sourceName);//模糊条件查询
}
