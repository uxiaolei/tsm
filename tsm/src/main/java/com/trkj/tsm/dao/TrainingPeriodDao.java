package com.trkj.tsm.dao;

import com.trkj.tsm.entity.TrainingPeriod;
import com.trkj.tsm.vo.TrainingPeriodVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 培训时段表(TrainingPeriod)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-04 11:33:34
 */
@Mapper
public interface TrainingPeriodDao {

    TrainingPeriod queryById(Integer periodId);

    List<TrainingPeriod> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<TrainingPeriod> queryAll(TrainingPeriod trainingperiod);

    int insert(TrainingPeriodVo trainingPeriodVo);

    int insertBatch(@Param("entities") List<TrainingPeriod> entities);

    int insertOrUpdateBatch(@Param("entities") List<TrainingPeriod> entities);

    int updateByTrainingPeriodKey(TrainingPeriodVo trainingPeriodVo);

    int deleteById(Integer periodId);

    List<TrainingPeriodVo> selectAllTrainingPeriod();
    int deleteByTrainingPeriod(TrainingPeriodVo trainingPeriodVo);
}

