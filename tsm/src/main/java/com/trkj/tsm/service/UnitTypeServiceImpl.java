package com.trkj.tsm.service;

import com.trkj.tsm.dao.UnittypeDao;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.UnitTypeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UnitTypeServiceImpl implements UnitTypeService {
    @Resource
    private UnittypeDao unittypeDao;
    @Override
    public List<UnitTypeVo> selectAllUnitType() {
        return unittypeDao.selectAllUnitType();
    }

    @Override
    public UnitTypeVo insertUnitType(UnitTypeVo unitTypeVo) {
        unitTypeVo.setAddtime(new Date());
        unittypeDao.insertUnitType(unitTypeVo);
        return unitTypeVo;
    }

    @Override
    public UnitTypeVo updateNameByPrimaryKey(UnitTypeVo unitTypeVo) {
        unitTypeVo.setUpdatetime(new Date());
        unittypeDao.updateNameById(unitTypeVo);
        return unitTypeVo;
    }

    @Override
    public UnitTypeVo deleteUnitType(UnitTypeVo unitTypeVo) {
        unitTypeVo.setDeletetime(new Date());
        unitTypeVo.setTimeliness(1);
        unittypeDao.deleteById(unitTypeVo);
        return unitTypeVo;
    }

    @Override
    public List<UnitTypeVo> selectUnitTypeByName(String unittypeName) {
        return unittypeDao.selectUnitTypeByName(unittypeName);
    }

    @Override
    public AjaxResponse deleteUnitTypeMany(String ids,String name) {
        String[] id= ids.split(",");
        for(String s : id){
            UnitTypeVo unitTypeVo = new UnitTypeVo();
            unitTypeVo.setDeletename(name);
            unitTypeVo.setDeletetime(new Date());
            unitTypeVo.setTimeliness(1);
            unitTypeVo.setUnittypeId(Integer.parseInt(s));
            unittypeDao.deleteById(unitTypeVo);
        }
        return AjaxResponse.success();
    }
}
