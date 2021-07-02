package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Refund;
import com.trkj.tsm.service.RefundService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.BackVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class RefundController {
    @Autowired
    private RefundService refundService;

    @GetMapping("/seleAllRefund")
    public PageInfo<Refund> seleAllRefund(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("classesName") String classesName) {
        log.debug("查询成功+++++++++++");
        PageHelper.startPage(currentPage, pagesize);
        List<Refund> refundList = refundService.seleAllRefund(classesName);
        PageInfo<Refund> refundPageInfo = new PageInfo<>(refundList);
        return refundPageInfo;
    }

    @PostMapping("/addRefund")
    public AjaxResponse addRefund(@RequestBody @Valid BackVo backVo){
        //refundService.addRefund(backVo);

        return AjaxResponse.success("审核通过");
    }

    @PutMapping("/delRefund")
    public String delRefund(@RequestBody @Valid Refund refund){
        refundService.delRefund(refund.getRefundId());
        return "删除成功";
    }

    @PutMapping("/upcwApproval")
    public AjaxResponse upcwApproval(@RequestBody @Valid Refund refund){
        log.debug("修改审核");
        refundService.upcwApproval(refund);
        return AjaxResponse.success(refund);
    }

}
