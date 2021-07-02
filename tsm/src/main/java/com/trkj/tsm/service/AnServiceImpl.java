package com.trkj.tsm.service;

import com.trkj.tsm.dao.AnnouncementDao;
import com.trkj.tsm.entity.Announcement;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AnServiceImpl implements AnService {
    @Resource
    private AnnouncementDao announcementDao;
    @Override
    public List<AnnouncementVo> selectAllAn() {
        return announcementDao.selectAllAn();
    }

    @Override
    public List<AnnouncementVo> selectAnByType(String announcementtypeName) {
        return announcementDao.selectAnByType(announcementtypeName);
    }

    @Override
    public List<AnnouncementVo> selectAnByContent(String announcementContent) {
        return announcementDao.selectAnByContent(announcementContent);
    }

    @Override
    public List<AnnouncementVo> selectAnByTheme(String announcementTheme) {
        return announcementDao.selectAnByTheme(announcementTheme);
    }

    @Override
    public AnnouncementVo insertAn(AnnouncementVo announcementVo) {
        announcementVo.setAddtime(new Date());
        announcementDao.insertAn(announcementVo);
        return announcementVo;
    }

    @Override
    public AnnouncementVo updateAn(AnnouncementVo announcementVo) {
        announcementVo.setUpdatetime(new Date());
        announcementDao.updateAn(announcementVo);
        return announcementVo;
    }

    @Override
    public AnnouncementVo deleteAn(AnnouncementVo announcementVo) {
        announcementVo.setDeletetime(new Date());
        announcementVo.setTimeliness(1);
        announcementDao.deleteAn(announcementVo);
        return announcementVo;
    }

    @Override
    public AnnouncementVo updateAnStateGo(AnnouncementVo announcementVo) {
        announcementVo.setAnnouncementState(1);
        announcementVo.setPublishtime(new Date());
        announcementDao.updateAnStateGo(announcementVo);
        return announcementVo;
    }

    @Override
    public AnnouncementVo updateAnStateStop(AnnouncementVo announcementVo) {
        announcementVo.setAnnouncementState(2);
        announcementVo.setPublishtime(new Date());
        announcementDao.updateAnStateGo(announcementVo);
        return announcementVo;
    }

    @Override
    public List<AnnouncementVo> selectAnByStateYES() {
        return announcementDao.selectAnByStateYES();
    }

    @Override
    public List<AnnouncementVo> selectAnByStateNO() {
        return announcementDao.selectAnByStateNO();
    }

    @Override
    public AjaxResponse deleteAnMany(String ids, String updatename) {
        String id[]=ids.split(",");
        for (String s:id){
            AnnouncementVo announcementVo=new AnnouncementVo();
            announcementVo.setDeletetime(new Date());
            announcementVo.setDeletename(updatename);
            announcementVo.setTimeliness(1);
            announcementVo.setAnnouncementId(Integer.parseInt(s));
            announcementDao.deleteAn(announcementVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public AjaxResponse updateAnStateGoMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s: id) {
            AnnouncementVo announcementVo=new AnnouncementVo();
            announcementVo.setAnnouncementId(Integer.parseInt(s));
            announcementVo.setPublishtime(new Date());
            announcementVo.setPublishname(updatename);
            announcementVo.setAnnouncementState(1);
            announcementDao.updateAnStateGo(announcementVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public AjaxResponse updateAnStateStopMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s: id) {
            AnnouncementVo announcementVo=new AnnouncementVo();
            announcementVo.setAnnouncementId(Integer.parseInt(s));
            announcementVo.setSuspentime(new Date());
            announcementVo.setSuspenname(updatename);
            announcementVo.setAnnouncementState(2);
            announcementDao.updateAnStateStop(announcementVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public Announcement selectAnById(Integer anid) {
        return announcementDao.selectAnById(anid);
    }
}
