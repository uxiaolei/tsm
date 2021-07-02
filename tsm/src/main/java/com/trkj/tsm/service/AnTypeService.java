package com.trkj.tsm.service;

import com.trkj.tsm.entity.Announcementtype;
import com.trkj.tsm.vo.AjaxResponse;

import java.util.List;

public interface AnTypeService {
    Announcementtype insert(Announcementtype announcementtype);

    List<Announcementtype> selectAllAnType();

    Announcementtype updateNameById(Announcementtype announcementtype);

    Announcementtype deleteById(Announcementtype announcementtype);

    List<Announcementtype> selectAnTypeByName(String announcementtypeName);

    AjaxResponse deleteAnTypeMany(String ids,String updatename);
}
