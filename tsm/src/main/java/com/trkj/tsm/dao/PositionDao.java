package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Position;
import com.trkj.tsm.vo.PositionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionDao {
    int deleteByPrimaryKey(Integer positionId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    /**
     *查询所有职位
     * @return
     */
    List<PositionVo> selectAllPosition();

    /**
     *添加职位
     * @param positionVo
     * @return
     */
    int insertPosition(PositionVo positionVo);

    /**
     *修改职位
     * @param positionVo
     * @return
     */
    int updatePosition(PositionVo positionVo);

    /**
     *删除职位
     * @param positionVo
     * @return
     */
    int deletePosition(PositionVo positionVo);

    /**
     * 根据职位名称模糊查询
     * @param positionName
     * @return
     */
    List<PositionVo> selectPositionByName(String positionName);
}