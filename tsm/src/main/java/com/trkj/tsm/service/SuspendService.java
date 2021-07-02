package com.trkj.tsm.service;

import com.trkj.tsm.vo.SuspendVo;

import java.util.List;

public interface SuspendService {
    List<SuspendVo> selectAllSuspend ();

    SuspendVo addSuspend(SuspendVo suspendVo);

    SuspendVo updateSuspend(SuspendVo suspendVo);

    int updateSuspend_Approval1(Integer suspendId);

    int deleteSuspend(Integer suspendId);
}
