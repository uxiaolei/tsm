package com.trkj.tsm.service;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.trkj.tsm.dao.AdvancearrangeDao;
import com.trkj.tsm.dao.ArrangeDao;
import com.trkj.tsm.dao.ClassesDao;
import com.trkj.tsm.dao.CourseDetailsDao;
import com.trkj.tsm.entity.Classes;
import com.trkj.tsm.vo.AdvancearrangeVo;
import com.trkj.tsm.vo.ArrangeVo;
import com.trkj.tsm.vo.ClassesVo;
import com.trkj.tsm.vo.CourseDetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
@Slf4j
public class AdvancearrangeServiceImpl implements AdvancearrangeService {
    @Resource
    private AdvancearrangeDao advancearrangeDao;

    @Resource
    private CourseDetailsDao courseDetailsDao;
    @Resource
    private ArrangeDao arrangeDao;
    @Resource
    private ClassesDao classesDao;

    @Override
    @Transactional
    public int addAdvancearrange(AdvancearrangeVo record) {
        return advancearrangeDao.addAdvancearrange(record);
    }

    @Override
    public List<AdvancearrangeVo> selectAllAdvancearrange() {
        return advancearrangeDao.selectAllAdvancearrange();
    }

    @Override
    @Transactional
    public int updateByAdvancearrangeKey(AdvancearrangeVo record) {
        return advancearrangeDao.updateByAdvancearrangeKey(record);
    }

    @Override
    @Transactional
    public int clearArrange() {
        return advancearrangeDao.clearArrange();
    }

    @Override
    @Transactional
    public void appArrange(List<AdvancearrangeVo> arrangeFormVoList) {

        List<Integer> classIds = new ArrayList<>();
        for (int i = 0;i<arrangeFormVoList.size();i++){
            classIds.add(arrangeFormVoList.get(i).getClassesId());
        }
        HashSet set = new HashSet(classIds);
        classIds.clear();
        classIds.addAll(set);
        List<AdvancearrangeVo> newArrangeFormVoList = new ArrayList<>();
        for (Integer integer:classIds){
            List<AdvancearrangeVo> advancearrangeVos = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();
            for (int i = 0;i<arrangeFormVoList.size();i++){
                if(arrangeFormVoList.get(i).getClassesId()==integer){
                    advancearrangeVos.add(arrangeFormVoList.get(i));
                }
            }
            //根据班级编号查询班级信息
            Classes classesVo = classesDao.selectByPrimaryKey(integer);
            CourseDetailsVo courseDetailsVo = courseDetailsDao.queryById(classesVo.getCoursedetailsId());
            List<CourseDetailsVo> courseDetailsVoList =courseDetailsDao.selectArrangeInfo(courseDetailsVo.getCourseId(),courseDetailsVo.getCoursesequence());
            if(courseDetailsVoList.size()!=1){  //courseDetailsVoList.size()==1表示已经排到了最后一个课程详细
                int isEnd=0;//判断是不是这次就可以排完
                if(advancearrangeVos.size()>=courseDetailsVoList.size()){
                    classesVo.setManylessons(courseDetailsVoList.size());
                    isEnd=1;
                }
                for (int i = 0;i<classesVo.getManylessons();i++){
                    advancearrangeVos.get(i).setCoursedetailsId(courseDetailsVoList.get(i).getCoursedetailsId());
                    ids.add(courseDetailsVoList.get(i).getCoursesequence());
                    newArrangeFormVoList.add(advancearrangeVos.get(i));
                }
                int id = ids.get(ids.size()-1);
                int newcourseDetailsId = 0;
                for (int i = 0; i<courseDetailsVoList.size();i++){
                    if(courseDetailsVoList.get(i).getCoursesequence()==id){
                        if (isEnd == 0) {
                            newcourseDetailsId = courseDetailsVoList.get(i+1).getCoursedetailsId();
                        }else{
                            newcourseDetailsId = courseDetailsVoList.get(i).getCoursedetailsId();
                        }

                    }
                }
                classesVo.setCoursedetailsId(newcourseDetailsId);
                classesDao.updateCoursedetailsIdByClassesId(classesVo);
            }

        }
        for (AdvancearrangeVo advancearrangeVo:newArrangeFormVoList){
            ArrangeVo arrangeVo = new ArrangeVo();
            arrangeVo.setAddname(advancearrangeVo.getAddname());
            arrangeVo.setArrangeDate(advancearrangeVo.getArrangeDate());
            arrangeVo.setClassesId(advancearrangeVo.getClassesId());
            arrangeVo.setClassroomId(advancearrangeVo.getClassroomId());
            arrangeVo.setPeriodId(advancearrangeVo.getPeriodId());
            arrangeVo.setEmpId(advancearrangeVo.getEmpId());
            arrangeVo.setCoursedetailsId(advancearrangeVo.getCoursedetailsId());
            arrangeDao.addArrange(arrangeVo);
        }
        log.debug("--------------------------------------------------------------");
        advancearrangeDao.clearArrange();
    }
}
