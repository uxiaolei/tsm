package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Shift;
import com.trkj.tsm.vo.ShiftVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShiftDao {
    int deleteByPrimaryKey(Integer shiftId);

    int insert(Shift record);

    int insertSelective(Shift record);

    Shift selectByPrimaryKey(Integer shiftId);

    int updateByPrimaryKeySelective(ShiftVo record);

    int updateByPrimaryKey(Shift record);

    List<ShiftVo> selectAllShift();
}