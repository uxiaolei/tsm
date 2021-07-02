package com.trkj.tsm.service;

import com.trkj.tsm.dao.SystemtypeDao;
import com.trkj.tsm.entity.Systemtype;
import com.trkj.tsm.vo.AjaxResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SystemTypeServiceImpl implements SystemTypeService {
    @Resource
    private SystemtypeDao systemtypeDao;
    @Override
    public Systemtype insert(Systemtype systemtype) {
        systemtype.setAddtime(new Date());
        systemtype.setTimeliness(0);
        systemtypeDao.insert(systemtype);
        return systemtype;
    }

    @Override
    public List<Systemtype> selectAllSystemType() {
        return systemtypeDao.selectAllSystemType();
    }

    @Override
    public Systemtype updateNameById(Systemtype systemtype) {
        systemtype.setUpdatetime(new Date());
        systemtypeDao.updateNameById(systemtype);
        return systemtype;
    }

    @Override
    public Systemtype deleteById(Systemtype systemtype) {
        systemtype.setDeletetime(new Date());
        systemtype.setTimeliness(1);
        systemtypeDao.deleteById(systemtype);
        return systemtype;
    }

    @Override
    public List<Systemtype> selectSystemTypeByName(String systemtypeName) {
        return systemtypeDao.selectSystemTypeByName(systemtypeName);
    }

    @Override
    public AjaxResponse deleteSystemTypeMany(String ids,String updatename) {
        String[] id=ids.split(",");
        for (String s:id){
            Systemtype systemtype=new Systemtype();
            systemtype.setDeletetime(new Date());
            systemtype.setTimeliness(1);
            systemtype.setDeletename(updatename);
            systemtype.setSystemtypeId(Integer.parseInt(s));
            systemtypeDao.deleteById(systemtype);
        }
        return AjaxResponse.success();
    }
}
