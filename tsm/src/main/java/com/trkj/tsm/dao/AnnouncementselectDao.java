package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Announcementselect;
import com.trkj.tsm.vo.AnnouncementselectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementselectDao {
    int deleteByPrimaryKey(Integer announcementselectId);

    int insert(Announcementselect record);

    int insertSelective(Announcementselect record);

    Announcementselect selectByPrimaryKey(Integer announcementselectId);

    int updateByPrimaryKeySelective(Announcementselect record);

    int updateByPrimaryKey(Announcementselect record);

    int insertAnSelect(AnnouncementselectVo announcementselectVo);

    List<Announcementselect> selectEmpIdByAnId(Integer announcementId);

    List<AnnouncementselectVo> selectAnsByEmpId(Integer empId);

    AnnouncementselectVo updateAnsById(AnnouncementselectVo announcementselectVo);
}