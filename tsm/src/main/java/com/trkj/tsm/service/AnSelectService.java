package com.trkj.tsm.service;

import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementselectVo;

import java.util.List;

public interface AnSelectService {
    AjaxResponse insertAnSelect(Integer anId, String deptId);
    List<Integer> selectEmpIdByAnId(Integer announcementId);
    List<AnnouncementselectVo> selectAnsByEmpId(Integer empId);
    AnnouncementselectVo updateAnsById(AnnouncementselectVo announcementselectVo);
}
