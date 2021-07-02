package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.PositionVo;

import java.util.List;

public interface PositionService {
    List<PositionVo> selectAllPosition();
    PositionVo insertPosition(PositionVo positionVo);
    PositionVo updatePosition(PositionVo positionVo);
    PositionVo deletePosition(PositionVo positionVo);
    AjaxResponse deletePositionMany(String ids);
    List<PositionVo> selectPositionByName(String positionName);
}
