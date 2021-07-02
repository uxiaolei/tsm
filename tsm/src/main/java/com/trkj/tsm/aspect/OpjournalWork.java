package com.trkj.tsm.aspect;

import com.trkj.tsm.aspect.aop.OpjournalAnnotation;
import com.trkj.tsm.entity.Announcement;
import com.trkj.tsm.service.AnService;
import com.trkj.tsm.service.OpjournalService;
import com.trkj.tsm.vo.AnnouncementVo;
import com.trkj.tsm.vo.OpjournalVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;


@Component
@Aspect
@Slf4j
public class OpjournalWork {
    @Resource
    private OpjournalService opjournalService;
    @Resource
    private AnService anService;

    @Pointcut("execution(* com.trkj.tsm.service..*.*(..))")
    public void x() {

    }

//    @Around("x()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.debug(">>>>>>>即将进入到{}类的{}方法",
//                joinPoint.getTarget().getClass().getName(), joinPoint.getSignature());
//        Object obj = joinPoint.proceed();
//        Object[] args = joinPoint.getArgs();
//        String name = joinPoint.getSignature().getName().substring(0, 3);
//        String name2 = joinPoint.getSignature().getName();
//        log.debug(">>>使用方法" + name);
//        log.debug(">>>使用方法名称" + name2);
//        if (name.equals("add") || name.equals("ins")) {
//            if (name2.equals("insertAnSelect")) {
//                Object[] values = joinPoint.getArgs();
//                String value = values[0].toString();
//                Integer anid = Integer.parseInt(value);
//                Announcement announcement = anService.selectAnById(anid);
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(announcement.getAddname());
//                opjournalVo.setOpcontent("新增公告允许查看");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else {
//                Class classname = args[0].getClass();
//                OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//                String entityname = opjournalAnnotation.message();
//                String opjournal = args[0].getClass().getDeclaredField("addname").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("新增" + entityname);
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            }
//        } else if (name.equals("upd")) {
//            if (name2.equals("updateAnStateGo")) {
//                Class classname = args[0].getClass();
//                OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//                String entityname = opjournalAnnotation.message();
//                String opjournal = args[0].getClass().getDeclaredField("publishname").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("发布" + entityname);
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("updateAnStateStop")) {
//                Class classname = args[0].getClass();
//                OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//                String entityname = opjournalAnnotation.message();
//                String opjournal = args[0].getClass().getDeclaredField("suspenname").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("发布" + entityname);
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("updateAnStateGoMany")) {
//                Object[] values = joinPoint.getArgs();
//                String updatename = values[1].toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(updatename);
//                opjournalVo.setOpcontent("批量发布公告");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("updateAnStateStopMany")) {
//                Object[] values = joinPoint.getArgs();
//                String updatename = values[1].toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(updatename);
//                opjournalVo.setOpcontent("批量暂停公告");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else {
//                Class classname = args[0].getClass();
//                OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//                String entityname = opjournalAnnotation.message();
//                String opjournal = args[0].getClass().getDeclaredField("updatename").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("修改" + entityname);
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            }
//        } else if (name.equals("del")) {
//            if (name2.equals("delinterview")) {
//                String opjournal = args[0].getClass().getDeclaredField("deletename").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("删除学员访谈");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("deleteAnTypeMany")) {
//                Object[] values = joinPoint.getArgs();
//                String updatename = values[1].toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(updatename);
//                opjournalVo.setOpcontent("批量删除公告类型");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("deleteSystemTypeMany")) {
//                Object[] values = joinPoint.getArgs();
//                String updatename = values[1].toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(updatename);
//                opjournalVo.setOpcontent("批量删除制度类型");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else if (name2.equals("deleteAnMany")) {
//                Object[] values = joinPoint.getArgs();
//                String updatename = values[1].toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(updatename);
//                opjournalVo.setOpcontent("批量删除公告");
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            } else {
//                Class classname = args[0].getClass();
//                OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//                String entityname = opjournalAnnotation.message();
//                log.debug(entityname);
//                String opjournal = args[0].getClass().getDeclaredField("deletename").get(args[0]).toString();
//                OpjournalVo opjournalVo = new OpjournalVo();
//                opjournalVo.setOperator(opjournal);
//                opjournalVo.setOpcontent("删除" + entityname);
//                opjournalVo.setOptiome(new Date());
//                opjournalService.setOpjournal(opjournalVo);
//            }
//        } else if (name.equals("app")) {
//            Class classname = args[0].getClass();
//            OpjournalAnnotation opjournalAnnotation = (OpjournalAnnotation) classname.getAnnotation(OpjournalAnnotation.class);
//            String entityname = opjournalAnnotation.message();
//            String opjournal = args[0].getClass().getDeclaredField("approvalname").get(args[0]).toString();
//            OpjournalVo opjournalVo = new OpjournalVo();
//            opjournalVo.setOperator(opjournal);
//            opjournalVo.setOpcontent("审批" + entityname);
//            opjournalVo.setOptiome(new Date());
//            opjournalService.setOpjournal(opjournalVo);
//        }
//        log.debug("<<<<<<<完成{}类的{}方法执行",
//                joinPoint.getTarget().getClass().getName(), joinPoint.getSignature());
//        return obj;
//    }
}
