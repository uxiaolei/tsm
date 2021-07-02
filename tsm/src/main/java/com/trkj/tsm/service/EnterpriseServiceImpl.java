package com.trkj.tsm.service;

import com.trkj.tsm.dao.EnterpriseDao;
import com.trkj.tsm.vo.EnterpriseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Resource
    private EnterpriseDao enterpriseDao;
    @Override
    public List<EnterpriseVo> selectAllEnterprise() {
        return enterpriseDao.selectAllEnterprise();
    }
}
