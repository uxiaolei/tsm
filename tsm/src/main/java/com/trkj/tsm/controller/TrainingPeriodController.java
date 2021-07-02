package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.service.TrainingPeriodService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.TrainingPeriodVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 培训时段表(TrainingPeriod)表控制层
 *
 * @author makejava
 * @since 2021-06-04 11:33:35
 */
@RestController
@Slf4j
public class TrainingPeriodController {

    @Resource
    private TrainingPeriodService trainingperiodService;

    @GetMapping("/selectAllTrainingPeriod")
    public PageInfo<TrainingPeriodVo> selectAllTrainingPeriod(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<TrainingPeriodVo> list = trainingperiodService.selectAllTrainingPeriod();
        PageInfo<TrainingPeriodVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @GetMapping("/selectAllTrainingPeriodList")
    public List<TrainingPeriodVo> selectAllTrainingPeriodList(){
        List<TrainingPeriodVo> list = trainingperiodService.selectAllTrainingPeriod();
        return list;
    }

    @PostMapping("/addTrainingPeriod")
    public AjaxResponse addTrainingPeriod(@RequestBody @Valid TrainingPeriodVo trainingPeriodVo){
        Date date = new Date();
        trainingPeriodVo.setAddtime(date);
        trainingperiodService.addTrainingPeriod(trainingPeriodVo);
        return AjaxResponse.success(trainingPeriodVo);
    }

    @PutMapping("/updateByTrainingPeriodKey")
    public AjaxResponse updateByTrainingPeriodKey(@RequestBody @Valid TrainingPeriodVo trainingPeriodVo){
        Date date = new Date();
        trainingPeriodVo.setUpdatetime(date);
        trainingperiodService.updateByTrainingPeriodKey(trainingPeriodVo);
        return  AjaxResponse.success(trainingPeriodVo);
    }

    @PutMapping("/deleteByTrainingPeriod")
    public AjaxResponse deleteByTrainingPeriod(@RequestBody @Valid TrainingPeriodVo trainingPeriodVo){
        Date date = new Date();
        trainingPeriodVo.setDeletetime(date);
        trainingPeriodVo.setTimeliness(1);
        trainingperiodService.deleteByTrainingPeriod(trainingPeriodVo);
        return AjaxResponse.success(trainingPeriodVo);
    }

}
