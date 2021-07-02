package com.trkj.tsm.controller;

import com.trkj.tsm.service.sessionService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class SessionController {
    @Resource
    private sessionService sessionService;

    @GetMapping("/selectSession")
    public List<Session> selectByPrimaryKey(){
        return sessionService.selectByPrimaryKey();
    }
    @PostMapping("/insertsession")
    public AjaxResponse insertsession(@RequestBody Session session){
        session.setAddname("梁政");
        session.setAddtime(new Date());
        session.setTimeliness(0);
        return AjaxResponse.success("");

    }
    @PutMapping("/updatesession")
    public AjaxResponse updateByPrimaryKey(@RequestBody Session session){
        session.setDeletename("梁政");
        session.setDeletetime(new Date());
        session.setTimeliness(0);
        return AjaxResponse.success("");
    }
    @PutMapping("/delectsession")
    public AjaxResponse deleteByPrimaryKey(@RequestBody Session session){
        return AjaxResponse.success("");
    }
}
