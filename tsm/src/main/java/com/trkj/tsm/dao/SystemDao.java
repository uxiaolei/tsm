package com.trkj.tsm.dao;

import com.trkj.tsm.vo.SystemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDao {
    int deleteByPrimaryKey(Integer systemId);

    int insert(System record);

    int insertSelective(System record);

    System selectByPrimaryKey(Integer systemId);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    /**
     * 查询所有制度
     * @return
     */
    List<SystemVo> selectAllSystem();

    /**
     * 添加制度
     * @param systemVo
     * @return
     */
    int insertSystem(SystemVo systemVo);

    /**
     * 修改制度状态 发布、暂停
     */
    int updateSystemStateGo(SystemVo systemVo);
    int updateSystemStateStop(SystemVo systemVo);

    /**
     * 修改制度
     */
    int updateSystem(SystemVo systemVo);

    /**
     * 删除制度
     */
    int deleteSystem(SystemVo systemVo);

    /**
     * 根据状态查询：已发布、未发布(包括已暂停的)
     */
    List<SystemVo> selectSystemByStateYES();
    List<SystemVo> selectSystemByStateNO();

    /**
     * 根据条件模糊查询：主题、类型、发文单位
     */
    List<SystemVo> selectSystemByDept(String deptName);
    List<SystemVo> selectSystemByTheme(String systemTheme);
    List<SystemVo> selectSystemByType(String systemTypeName);
}