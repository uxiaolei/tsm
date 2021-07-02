package com.trkj.tsm.service;



import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitVo;

import java.util.List;

public interface UnitService {
    List<UnitVo> selectAllUnit();
    UnitVo insertUnit(UnitVo unitVo);
    UnitVo updateUnit(UnitVo unitVo);
    UnitVo deleteUnit(UnitVo unitVo);
    List<UnitVo> selectUnitByName (String unitName);
    List<UnitVo> selectUnitByUnitTypeName (String unittypeName);
    List<UnitVo> selectUnitByLevel (String unitLevel);
    List<UnitVo> selectUnitByDirector(String director);
    List<UnitVo> selectUnitByAddress(String unitAddress);
    AjaxResponse deleteUnitMany(String ids);
}
