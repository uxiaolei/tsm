package com.trkj.tsm.service;

import com.trkj.tsm.vo.BackVo;
import com.trkj.tsm.vo.SuspendVo;

import java.util.List;

public interface BackService {
    List<BackVo> selectAllBack();

    BackVo addBack(BackVo backVo);

    BackVo updateBack(BackVo backVo);

    int updateBack_Approval(Integer backId);

    int deleteBack(Integer backId);
}
