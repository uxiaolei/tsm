package com.trkj.tsm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.tsm.entity.Memorandumattachment;
import com.trkj.tsm.service.MemorandumattachmentService;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.MemorandumattachmentVo;
import com.trkj.tsm.vo.SourceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class MemorandumattachmentController {
    @Autowired
    private MemorandumattachmentService memorandumattachmentService;

    @GetMapping("/seleAllmemorandumatt")
    public PageInfo<MemorandumattachmentVo> seleAllmemorandumatt(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("flag") String flag){
        log.debug("查询显示学员交接");
        PageHelper.startPage(currentPage,pagesize);
        List<MemorandumattachmentVo> memorandumattachmentVoList=memorandumattachmentService.seleAllmemorandumatt(flag);
        PageInfo<MemorandumattachmentVo> memorandumattachmentVoPageInfo=new PageInfo<>(memorandumattachmentVoList);
        return memorandumattachmentVoPageInfo;
    }
    @GetMapping("/seleAllmemorandumatt1")
    public PageInfo<MemorandumattachmentVo> seleAllmemorandumatt1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询招生审核为1的学员交接信息");
        PageHelper.startPage(currentPage,pagesize);
        List<MemorandumattachmentVo> memorandumattachmentVoList=memorandumattachmentService.seleAllmemorandumatt1();
        PageInfo<MemorandumattachmentVo> memorandumattachmentVoPageInfo=new PageInfo<>(memorandumattachmentVoList);
        return memorandumattachmentVoPageInfo;
    }

    @PostMapping("/addmemorandumatt")
    public AjaxResponse addmemorandumatt(@RequestBody @Valid Memorandumattachment memorandumattachment){
        log.debug("新增成功");
        memorandumattachmentService.addmemorandumatt(memorandumattachment);
        return AjaxResponse.success("成功新增学员交接记录");
    }

    @PutMapping("/upzsisexamine")
    public AjaxResponse upzsisexamine(@RequestBody @Valid Memorandumattachment memorandumattachment){
        log.debug("审核成功");
        memorandumattachmentService.upzsisexamine(memorandumattachment);
        return AjaxResponse.success(memorandumattachment);
    }

    @PutMapping("/upjwisexamine")
    public AjaxResponse upjwisexamine(@RequestBody @Valid Memorandumattachment memorandumattachment){
        log.debug("审核成功");
        memorandumattachmentService.upjwisexamine(memorandumattachment);
        return AjaxResponse.success(memorandumattachment);
    }

    @GetMapping("/yshzsisexamine")
    public PageInfo<Memorandumattachment> yshzsisexamine(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("招生已审核模糊查询");
        PageHelper.startPage(currentPage, pagesize);//分页查出结果和条数
        List<Memorandumattachment> memorandumattachments=memorandumattachmentService.yshzsisexamine();
        PageInfo<Memorandumattachment> memorandumattachmentPageInfo=new PageInfo<>(memorandumattachments);
        return memorandumattachmentPageInfo;

    }
    @GetMapping("/wshzsisexamine")
    public PageInfo<Memorandumattachment> wshzsisexamine(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("招生未审核模糊查询");
        PageHelper.startPage(currentPage, pagesize);//分页查出结果和条数
        List<Memorandumattachment> memorandumattachments=memorandumattachmentService.wshzsisexamine();
        PageInfo<Memorandumattachment> memorandumattachmentPageInfo=new PageInfo<>(memorandumattachments);
        return memorandumattachmentPageInfo;

    }
    @GetMapping("/yshjwisexamine")
    public PageInfo<Memorandumattachment> yshjwisexamine(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("教务已模糊查询");
        PageHelper.startPage(currentPage, pagesize);//分页查出结果和条数
        List<Memorandumattachment> memorandumattachments=memorandumattachmentService.yshjwisexamine();
        PageInfo<Memorandumattachment> memorandumattachmentPageInfo=new PageInfo<>(memorandumattachments);
        return memorandumattachmentPageInfo;

    }
    @GetMapping("/wshjwisexamine")
    public PageInfo<Memorandumattachment> wshjwisexamine(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("教务未模糊查询");
        PageHelper.startPage(currentPage, pagesize);//分页查出结果和条数
        List<Memorandumattachment> memorandumattachments=memorandumattachmentService.wshjwisexamine();
        PageInfo<Memorandumattachment> memorandumattachmentPageInfo=new PageInfo<>(memorandumattachments);
        return memorandumattachmentPageInfo;

    }

}
