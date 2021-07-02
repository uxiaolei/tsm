package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Unittype;
import com.trkj.tsm.vo.UnitTypeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnittypeDao {
    int deleteByPrimaryKey(Integer unittypeId);

    int insert(UnitTypeVo unitTypeVo);

    int insertSelective(Unittype unittype);

    Unittype selectByPrimaryKey(Integer unittypeId);

    int updateByPrimaryKeySelective(Unittype unittype);

    int updateByPrimaryKey(Unittype unittype);

    List<UnitTypeVo> selectAllUnitType();

    int insertUnitType(UnitTypeVo unitTypeVo);

    int updateNameById(UnitTypeVo unitTypeVo);

    int deleteById(UnitTypeVo unitTypeVo);

    List<UnitTypeVo> selectUnitTypeByName(String unittypeName);
}