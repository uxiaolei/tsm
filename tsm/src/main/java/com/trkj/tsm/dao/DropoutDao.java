package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Dropout;
import com.trkj.tsm.vo.DropoutVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DropoutDao {
    int deleteByPrimaryKey(Integer dropId);

    int insert(DropoutVo record);

    int insertSelective(DropoutVo record);

    DropoutVo selectByPrimaryKey(Integer dropId);

    int updateByPrimaryKeySelective(DropoutVo record);

    int updateByPrimaryKey(DropoutVo record);

    List<DropoutVo> selectAllDrop();
}