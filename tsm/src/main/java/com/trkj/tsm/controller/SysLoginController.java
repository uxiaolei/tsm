package com.trkj.tsm.controller;

import com.trkj.tsm.entity.SysMenu;
import com.trkj.tsm.exception.CustomError;
import com.trkj.tsm.exception.CustomErrorType;
import com.trkj.tsm.service.EmpService;
import com.trkj.tsm.service.JwtAuthService;
import com.trkj.tsm.service.LoginJournalService;
import com.trkj.tsm.service.SysPermissionService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.LoginVo;
import com.trkj.tsm.vo.LoginjournalVo;
import com.trkj.tsm.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class SysLoginController {
    @Resource
    private JwtAuthService jwtAuthService;
    @Resource
    private SysPermissionService permissionService;
    @Resource
    private EmpService  empService;
    @Resource
    private LoginJournalService loginJournalService;
    @PostMapping("/signout")
    public AjaxResponse signout(){
        log.debug("开始退出操作");
        AjaxResponse ajaxResponse=AjaxResponse.success("已退出");
        SecurityContextHolder.clearContext();
        return ajaxResponse;
    }
    @PostMapping("/login")
    public AjaxResponse login(@RequestBody LoginVo loginVo){
        log.debug("开始验证,{}", loginVo);
        String token = jwtAuthService.login(loginVo.getUsername(), loginVo.getPassword());
        List<SysMenu> menus = permissionService.getMenuByUname(loginVo.getUsername());
        int a = empService.findempid(loginVo.getUsername());
        log.debug(menus.toString());
        UserVo vo = new UserVo();
        vo.setId(empService.findempid(loginVo.getUsername()));
        vo.setUsername(loginVo.getUsername());
        vo.setValidate(true);
        vo.setMenus(menus);
        vo.setToken(token);
        LoginjournalVo loginjournalVo=new LoginjournalVo();
        loginjournalVo.setEmpId(empService.findempid(loginVo.getUsername()));
        loginjournalVo.setLogintime(new Date());
        loginJournalService.setLoginJlogin(loginjournalVo);
        return AjaxResponse.success(vo);

    }



}
