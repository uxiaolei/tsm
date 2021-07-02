package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Enterprise;
import com.trkj.tsm.vo.EnterpriseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnterpriseDao {
    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer enterpriseId);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);

    List<EnterpriseVo> selectAllEnterprise();
}