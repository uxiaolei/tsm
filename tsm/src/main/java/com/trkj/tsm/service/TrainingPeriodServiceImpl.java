package com.trkj.tsm.service;

import com.trkj.tsm.dao.TrainingPeriodDao;
import com.trkj.tsm.entity.TrainingPeriod;
import com.trkj.tsm.service.TrainingPeriodService;
import com.trkj.tsm.vo.TrainingPeriodVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TrainingPeriodServiceImpl implements TrainingPeriodService {
    @Resource
    private TrainingPeriodDao trainingPeriodDao;

    @Override
    public TrainingPeriod queryById(Integer periodId) {
        return null;
    }

    @Override
    public List<TrainingPeriod> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public TrainingPeriod insert(TrainingPeriod trainingperiod) {
        return null;
    }

    @Override
    public TrainingPeriod update(TrainingPeriod trainingperiod) {
        return null;
    }

    @Override
    public boolean deleteById(Integer periodId) {
        return false;
    }

    @Override
    public List<TrainingPeriodVo> selectAllTrainingPeriod() {
        return trainingPeriodDao.selectAllTrainingPeriod();
    }

    @Override
    @Transactional
    public void addTrainingPeriod(TrainingPeriodVo trainingPeriodVo) {
        trainingPeriodDao.insert(trainingPeriodVo);
    }

    @Override
    @Transactional
    public int deleteByTrainingPeriod(TrainingPeriodVo trainingPeriodVo) {
        return trainingPeriodDao.deleteByTrainingPeriod(trainingPeriodVo);
    }

    @Override
    @Transactional
    public int updateByTrainingPeriodKey(TrainingPeriodVo trainingPeriodVo) {
        return trainingPeriodDao.updateByTrainingPeriodKey(trainingPeriodVo);
    }
}
