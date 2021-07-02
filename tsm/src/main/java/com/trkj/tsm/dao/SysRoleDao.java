package com.trkj.tsm.dao;

import com.trkj.tsm.entity.SysRole;
import com.trkj.tsm.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<RoleVo> selAll();

    List<RoleVo> selAllmh(String rolename);//模糊查询

    List<String> findRoleByUserName(String username);

    List<RoleVo> selrolebyempid(int empid);
}