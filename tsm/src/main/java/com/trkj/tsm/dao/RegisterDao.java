package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Register;
import com.trkj.tsm.vo.RegisterVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegisterDao {
    int deleteByPrimaryKey(Integer registerId);

    int insert(RegisterVo record);

    int insertSelective(RegisterVo record);

    RegisterVo selectByPrimaryKey(Integer registerId);//通过咨询登记的id查询生源渠道的id

    int updateByPrimaryKeySelective(RegisterVo record);

    int updateByPrimaryKey(RegisterVo record);

    int upPayState (RegisterVo registerVo);//修改缴费状态

    List<RegisterVo> selectregisterAlls();

    List<RegisterVo> mhselectregister(String flag);//模糊查询

    List<Register>  ConsultationmodeStatistics();

}