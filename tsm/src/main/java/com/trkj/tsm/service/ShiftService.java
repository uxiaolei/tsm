package com.trkj.tsm.service;

import com.trkj.tsm.vo.ShiftVo;
import com.trkj.tsm.vo.SuspendVo;

import java.util.List;

public interface ShiftService {
    List<ShiftVo> selectAllShift();

    ShiftVo addShift(ShiftVo shiftVo);

    ShiftVo updateShift(ShiftVo shiftVo);

    int appShift_Approval1(Integer shiftId);

    int deleteShift(Integer shiftId);
}
