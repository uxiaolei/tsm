package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitTypeVo;

import java.util.List;

public interface UnitTypeService {
    List<UnitTypeVo> selectAllUnitType();
    UnitTypeVo insertUnitType(UnitTypeVo unitTypeVo);
    UnitTypeVo updateNameByPrimaryKey(UnitTypeVo unitTypeVo);
    UnitTypeVo deleteUnitType(UnitTypeVo unitTypeVo);
    List<UnitTypeVo> selectUnitTypeByName(String unittypeName);
    AjaxResponse deleteUnitTypeMany(String ids,String name);
}
