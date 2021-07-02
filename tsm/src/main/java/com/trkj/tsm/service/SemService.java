package com.trkj.tsm.service;

import com.trkj.tsm.vo.SemesterVo;

import java.util.List;

public interface SemService {
    List<SemesterVo> selectByPrimaryKey();
    SemesterVo insert(SemesterVo semestervo);
    SemesterVo updatesem(SemesterVo semestervo);
    SemesterVo deletesem(SemesterVo semestervo);
}
