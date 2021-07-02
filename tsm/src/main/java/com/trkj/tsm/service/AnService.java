package com.trkj.tsm.service;

import com.trkj.tsm.entity.Announcement;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementVo;

import java.util.List;

public interface AnService {
    List<AnnouncementVo> selectAllAn();
    List<AnnouncementVo> selectAnByType(String announcementtypeName);
    List<AnnouncementVo> selectAnByContent(String announcementContent);
    List<AnnouncementVo> selectAnByTheme(String announcementTheme);
    AnnouncementVo insertAn(AnnouncementVo announcementVo);
    AnnouncementVo updateAn(AnnouncementVo announcementVo);
    AnnouncementVo deleteAn(AnnouncementVo announcementVo);
    AnnouncementVo updateAnStateGo(AnnouncementVo announcementVo);
    AnnouncementVo updateAnStateStop(AnnouncementVo announcementVo);
    List<AnnouncementVo> selectAnByStateYES();
    List<AnnouncementVo> selectAnByStateNO();
    AjaxResponse deleteAnMany(String ids,String updatename);
    AjaxResponse updateAnStateGoMany(String ids,String updatename);
    AjaxResponse updateAnStateStopMany(String ids,String updatename);
    Announcement selectAnById(Integer anid);
}
