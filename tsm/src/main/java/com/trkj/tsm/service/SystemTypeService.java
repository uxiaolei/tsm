package com.trkj.tsm.service;

import com.trkj.tsm.entity.Systemtype;
import com.trkj.tsm.vo.AjaxResponse;

import java.util.List;

public interface SystemTypeService {
    Systemtype insert(Systemtype systemtype);

    List<Systemtype> selectAllSystemType();

    Systemtype updateNameById(Systemtype systemtype);

    Systemtype deleteById(Systemtype systemtype);

    List<Systemtype> selectSystemTypeByName(String systemtypeName);

    AjaxResponse deleteSystemTypeMany(String ids,String updatename);
}
