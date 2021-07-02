package com.trkj.tsm.dao;


import com.trkj.tsm.entity.Unit;
import com.trkj.tsm.vo.UnitVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitDao {
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    /**
     * 查询所有单位
     * @return
     */
    List<UnitVo> selectAllUnit();

    /**
     * 添加单位
     * @param unitVo
     * @return
     */
    int insertUnit(UnitVo unitVo);

    /**
     * 修改单位信息
     * @param unitVo
     * @return
     */
    int updateUnit(UnitVo unitVo);

    /**
     * 删除单位
     * @param unitVo
     * @return
     */
    int deleteUnit(UnitVo unitVo);

    /**
     * 根据条件某户查询 单位名称、单位类型、单位等级、单位地址、负责人
     * @param unitName
     * @return
     */
    List<UnitVo> selectUnitByName (String unitName);
    List<UnitVo> selectUnitByUnitTypeName (String unittypeName);
    List<UnitVo> selectUnitByLevel (String unitLevel);
    List<UnitVo> selectUnitByDirector(String director);
    List<UnitVo> selectUnitByAddress(String unitAddress);
}