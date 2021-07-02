package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Announcement;
import com.trkj.tsm.vo.AnnouncementVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementDao {
    int deleteByPrimaryKey(Integer announcementId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer announcementId);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);

    /**
     * 查询所有公告
     * @return
     */
    List<AnnouncementVo> selectAllAn();

    /**
     * 根据条件模糊查询：公告类型、公告内容、公告主题
     * @param announcementtypeName
     * @return
     */
    List<AnnouncementVo> selectAnByType(String announcementtypeName);
    List<AnnouncementVo> selectAnByContent(String announcementContent);
    List<AnnouncementVo> selectAnByTheme(String announcementTheme);

    /**
     * 添加公告
     * @param announcementVo
     * @return
     */
    int insertAn(AnnouncementVo announcementVo);

    /**
     * 修改公告
     * @param announcementVo
     * @return
     */
    int updateAn(AnnouncementVo announcementVo);

    /**
     * 删除公告
     * @param announcementVo
     * @return
     */
    int deleteAn(AnnouncementVo announcementVo);

    /**
     * 发布公告
     * @param announcementVo
     * @return
     */
    int updateAnStateGo(AnnouncementVo announcementVo);

    /**
     * 暂停公告
     * @param announcementVo
     * @return
     */
    int updateAnStateStop(AnnouncementVo announcementVo);

    /**
     * 根据状态查询：已发布、未发布(包括已暂停的)
     */
    List<AnnouncementVo> selectAnByStateYES();
    List<AnnouncementVo> selectAnByStateNO();

    Announcement selectAnById(Integer anid);
}