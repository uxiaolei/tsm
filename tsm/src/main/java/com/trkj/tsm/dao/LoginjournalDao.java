package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Loginjournal;
import com.trkj.tsm.vo.LoginjournalVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface LoginjournalDao {
    int deleteByPrimaryKey(Integer loginjournalId);

    int insert(Loginjournal record);

    int insertSelective(Loginjournal record);

    Loginjournal selectByPrimaryKey(Integer loginjournalId);

    int updateByPrimaryKeySelective(Loginjournal record);

    int updateByPrimaryKey(Loginjournal record);

    /**
     * 新增登录日志
     * @param loginjournalVo
     * @return
     */
    int insertLoginJlogin(LoginjournalVo loginjournalVo);

    /**
     * 查询所有登录日志
     * @return
     */
    List<LoginjournalVo> selectAllLoginJ();

    /**
     * 根据条件模糊查询：职工姓名、登录时间、登陆时间加职工姓名
     * @param empName
     * @return
     */
    List<LoginjournalVo> selectLoginJByEmp(String empName);

    List<LoginjournalVo> selectLoginJByLoginTime(String logintime);

    List<LoginjournalVo> selectLoginJByLoginTimeAndEmp(String time,String what);

}