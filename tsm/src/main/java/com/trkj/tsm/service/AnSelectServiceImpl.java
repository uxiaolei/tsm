package com.trkj.tsm.service;

import com.trkj.tsm.dao.AnnouncementselectDao;
import com.trkj.tsm.dao.EmpDao;
import com.trkj.tsm.entity.Announcementselect;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementselectVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnSelectServiceImpl implements AnSelectService {
    @Resource
    private AnnouncementselectDao announcementselectDao;
    @Resource
    private EmpDao empDao;

    @Override
    public AjaxResponse insertAnSelect(Integer anId, String deptId) {
        String[] deptIds=deptId.split(",");
        for (String did:deptIds){
            List<Emp> empIds=empDao.selectEmpIdByDeptId(Integer.parseInt(did));
            for (Emp eid:empIds){
                AnnouncementselectVo ansVo= new AnnouncementselectVo();
                Integer empid=eid.getEmpId();
                ansVo.setEmpId(empid);
                ansVo.setAnnouncementId(anId);
                announcementselectDao.insertAnSelect(ansVo);
            }
        }
        return AjaxResponse.success();
    }

    @Override
    public List<Integer> selectEmpIdByAnId(Integer announcementId) {
        //根据制度id得到所有公告允许查看表的信息
        List<Announcementselect> announcementselectList=announcementselectDao.selectEmpIdByAnId(announcementId);
        List<Integer> empids=new ArrayList<>();
        for(int i=0;i<announcementselectList.size();i++){
            //根据下标得到公告允许查看表的信息
            Announcementselect announcementselect=announcementselectList.get(i);
            //从公告允许查看表中得到empId
            Integer empid=announcementselect.getEmpId();
            //将得到的empId放到集合中
            empids.add(empid);
        }
        return empids;
    }

    @Override
    public List<AnnouncementselectVo> selectAnsByEmpId(Integer empId) {
        return announcementselectDao.selectAnsByEmpId(empId);
    }

    @Override
    public AnnouncementselectVo updateAnsById(AnnouncementselectVo announcementselectVo) {
        announcementselectVo.setReadstate(1);
        announcementselectVo.setReadtime(new Date());
        return announcementselectDao.updateAnsById(announcementselectVo);
    }
}
