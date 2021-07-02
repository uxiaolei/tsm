package com.trkj.tsm.service;

import com.trkj.tsm.dao.AnnouncementtypeDao;
import com.trkj.tsm.entity.Announcementtype;
import com.trkj.tsm.vo.AjaxResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AnTypeServiceImpl implements AnTypeService {
    @Resource
    private AnnouncementtypeDao announcementtypeDao;

    @Override
    public Announcementtype insert(Announcementtype announcementtype) {
        announcementtype.setAddtime(new Date());
        announcementtype.setTimeliness(0);
        announcementtypeDao.insert(announcementtype);
        return announcementtype;
    }

    @Override
    public List<Announcementtype> selectAllAnType() {
        return announcementtypeDao.selectAllAnType();
    }

    @Override
    public Announcementtype updateNameById(Announcementtype announcementtype) {
        announcementtype.setUpdatetime(new Date());
        announcementtypeDao.updateNameById(announcementtype);
        return announcementtype;
    }

    @Override
    public Announcementtype deleteById(Announcementtype announcementtype) {
        announcementtype.setDeletetime(new Date());
        announcementtype.setTimeliness(1);
        announcementtypeDao.deleteById(announcementtype);
        return announcementtype;
    }

    @Override
    public List<Announcementtype> selectAnTypeByName(String announcementtypeName) {
        return announcementtypeDao.selectAnTypeByName(announcementtypeName);
    }

    @Override
    public AjaxResponse deleteAnTypeMany(String ids, String updatename) {
        String[] id=ids.split(",");
        for (String s:id){
            Announcementtype announcementtype=new Announcementtype();
            announcementtype.setDeletename(updatename);
            announcementtype.setDeletetime(new Date());
            announcementtype.setAnnouncementtypeId(Integer.parseInt(s));
            announcementtype.setTimeliness(1);
            announcementtypeDao.deleteById(announcementtype);
        }
        return AjaxResponse.success();
    }
}
