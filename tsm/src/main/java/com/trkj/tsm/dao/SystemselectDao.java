package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Systemselect;
import com.trkj.tsm.vo.SystemselectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemselectDao {
    int deleteByPrimaryKey(Integer systemselectId);

    int insert(Systemselect record);

    int insertSelective(Systemselect record);

    Systemselect selectByPrimaryKey(Integer systemselectId);

    int updateByPrimaryKeySelective(Systemselect record);

    int updateByPrimaryKey(Systemselect record);

    int insertSystem(SystemselectVo systemselectVo);

    List<Systemselect> selectEmpIdBySystemId(Integer systemId);
}