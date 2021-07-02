package com.trkj.tsm.controller;

import com.trkj.tsm.service.SystemSelectService;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class SystemSelectController {
    @Resource
    private SystemSelectService systemSelectService;

    @PostMapping("/insertSystemSelect")
    public AjaxResponse insertSystemSelect(@RequestParam("systemId") Integer systemId, @RequestParam("deptId") String deptId) {
        systemSelectService.insertSystem(systemId, deptId);
        return AjaxResponse.success();
    }

    @GetMapping("/selectEmpIdBySystemId")
    public List<Integer> selectEmpIdBySystemId(@RequestParam("sid") Integer systemId){
        List<Integer> empIds=systemSelectService.selectEmpIdBySystemId(systemId);
        return empIds;
    }
}
