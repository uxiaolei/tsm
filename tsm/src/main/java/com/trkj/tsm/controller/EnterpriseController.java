package com.trkj.tsm.controller;

import com.trkj.tsm.dao.EnterpriseDao;
import com.trkj.tsm.vo.EnterpriseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class EnterpriseController {
    @Resource
    private EnterpriseDao enterpriseDao;

    @GetMapping("/selectAllEnterprise")
    public List<EnterpriseVo> selectAllEnterprise(){
        log.debug("查询所有企业档案信息");
        return enterpriseDao.selectAllEnterprise();
    }
}
