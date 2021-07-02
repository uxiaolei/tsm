package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.service.EmpService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.EmpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Resource
    private EmpService empService;

    @GetMapping("/selectAllEmp")
    public PageInfo<Emp> selectAllEmp(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<Emp> empPage = empService.selectAllEmp();
        PageInfo<Emp> empPageInfo = new PageInfo<>(empPage);
        return empPageInfo;
    }

    @GetMapping("/selectAllEmp2")
    public PageInfo<Emp> selectAllEmp2(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("flag") int depid) {
        PageHelper.startPage(currentPage, pagesize);
        List<Emp> empPage = empService.selectAllEmp2(depid);
        PageInfo<Emp> empPageInfo = new PageInfo<>(empPage);
        return empPageInfo;
    }

    @GetMapping("/wjselectAllEmp")
    public List<Emp> wjselectAllEmp(){
        log.debug("emp外键查询");
        List<Emp> empList=empService.selectAllEmp();
        return empList;
    }


    @PostMapping("/insertEmp")
    public EmpVo insertEmp(@RequestBody @Valid EmpVo emp) {
        return empService.insertEmp(emp);
    }


    @PutMapping("/goEmpState")
    public AjaxResponse goEmpState(@RequestBody @Valid EmpVo empVo) {
        return AjaxResponse.success(empService.goEmpState(empVo));
    }

    @PutMapping("/updateEmp")
    public AjaxResponse updateEmp(@RequestBody @Valid EmpVo empvo) {
        //修改emp方法
        empService.updateEmp(empvo);
//        String [] strs=roleId.split("&");
//
//        List<Integer> roleIds=new ArrayList<>();
//        for(int i=0,len=strs.length;i<len;i++){
//            String[] a=strs[i].split("=");
//            roleIds.add(Integer.valueOf(a[1]));
//        }


        return AjaxResponse.success("修改成功");
    }


}
