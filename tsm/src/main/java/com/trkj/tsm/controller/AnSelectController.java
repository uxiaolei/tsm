package com.trkj.tsm.controller;

import com.trkj.tsm.entity.Announcementselect;
import com.trkj.tsm.service.AnSelectService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.AnnouncementselectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class AnSelectController {
    @Resource
    private AnSelectService anSelectService;

    @DeleteMapping("/insertAnSelect")
    public AjaxResponse insertAnSelect(@RequestParam("announcementId") Integer anId, @RequestParam("deptId") String deptId) {
        anSelectService.insertAnSelect(anId, deptId);
        return AjaxResponse.success();
    }

    @GetMapping("/selectEmpIdByAnId")
    public List<Integer> selectEmpIdByAnId(@RequestParam("anid") Integer anId){
        List<Integer> empIds=anSelectService.selectEmpIdByAnId(anId);
        return empIds;
    }

    @GetMapping("/selectAnsByEmpId")
    public List<AnnouncementselectVo> selectAnsByEmpId(@RequestParam("empid") Integer empId){
        List<AnnouncementselectVo> announcementselectVos=anSelectService.selectAnsByEmpId(empId);
        log.debug(announcementselectVos.toString());
        return anSelectService.selectAnsByEmpId(empId);
    }

    @DeleteMapping("")
    public AjaxResponse a(@RequestBody AnnouncementselectVo announcementselectVo){
        anSelectService.updateAnsById(announcementselectVo);
        return AjaxResponse.success(announcementselectVo);
    }

}
