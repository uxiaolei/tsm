package com.trkj.tsm.service;

import com.trkj.tsm.dao.UnitDao;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UnitServiceImpl implements UnitService {
    @Resource
    private UnitDao unitDao;
    @Override
    public List<UnitVo> selectAllUnit() {
        return unitDao.selectAllUnit();
    }

    @Override
    public UnitVo insertUnit(UnitVo unitVo) {
        unitVo.setAddname("梁政");
        unitVo.setAddtime(new Date());
        unitDao.insertUnit(unitVo);
        return unitVo;
    }

    @Override
    public UnitVo updateUnit(UnitVo unitVo) {
        unitVo.setUpdatename("梁政");
        unitVo.setUpdatetime(new Date());
        unitDao.updateUnit(unitVo);
        return unitVo;
    }

    @Override
    public UnitVo deleteUnit(UnitVo unitVo) {
        unitVo.setDeletename("梁政");
        unitVo.setDeletetime(new Date());
        unitDao.deleteUnit(unitVo);
        return unitVo;
    }

    @Override
    public List<UnitVo> selectUnitByName(String unitName) {
        return unitDao.selectUnitByName(unitName);
    }

    @Override
    public List<UnitVo> selectUnitByUnitTypeName(String unittypeName) {
        return unitDao.selectUnitByUnitTypeName(unittypeName);
    }

    @Override
    public List<UnitVo> selectUnitByLevel(String unitLevel) {
        return unitDao.selectUnitByLevel(unitLevel);
    }

    @Override
    public List<UnitVo> selectUnitByDirector(String director) {
        return unitDao.selectUnitByDirector(director);
    }

    @Override
    public AjaxResponse deleteUnitMany(String ids) {
        String[] id=ids.split(",");
        for(String s:id){
            UnitVo unitVo = new UnitVo();
            unitVo.setDeletename("梁政");
            unitVo.setDeletetime(new Date());
            unitVo.setTimeliness(1);
            unitVo.setUnitId(Integer.parseInt(s));
            unitDao.deleteUnit(unitVo);
        }
        return AjaxResponse.success(id);
    }

    @Override
    public List<UnitVo> selectUnitByAddress(String unitAddress) {
        return unitDao.selectUnitByAddress(unitAddress);
    }
}
