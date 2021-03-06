package com.trkj.tsm.handle;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trkj.tsm.exception.CustomError;
import com.trkj.tsm.exception.CustomErrorType;
import com.trkj.tsm.util.ServletUtil;
import com.trkj.tsm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:已登录用户无权限处理类（Spring默认的AccessDeniedHandler中只有对页面请求的处理，而没有对Ajax的处理）
 * @version 1.0
 */
@Component
@Slf4j
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws JsonProcessingException {
        log.info("没有授权，无法访问");
        AjaxResponse ajaxResponse=AjaxResponse.error(new CustomError(CustomErrorType.ACCOUNT_ERROR1,"账号未授权当前操作授权，请联系管理员增加权限！"));
        ObjectMapper om=new ObjectMapper();
        ServletUtil.responseJson(response, om.writeValueAsString(ajaxResponse));
    }
}