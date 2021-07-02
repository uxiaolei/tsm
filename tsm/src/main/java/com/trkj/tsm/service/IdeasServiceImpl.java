package com.trkj.tsm.service;

import com.github.pagehelper.PageHelper;
import com.trkj.tsm.dao.IdeasDao;
import com.trkj.tsm.entity.Emp;
import com.trkj.tsm.entity.Suggest;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.IdeasVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class IdeasServiceImpl implements IdeasService {
    @Resource
    private IdeasDao ideasDao;
    @Resource
    private EmpService empService;
    @Resource
    private SuggestService suggestService;

    @Override
    public List<IdeasVo> selectAllIdeas() {
        return ideasDao.selectAllIdeas();
    }

    @Override
    public List<IdeasVo> selectIdeasBySuggest(Integer empId, int currentPage, int pagesize) {
        //根据职工id得到部门id
        Emp emp=empService.selectByPrimaryKey(empId);
        Integer deptId=emp.getDeptId();
        //通过部门id得到意见箱id
        Suggest suggest=suggestService.selectSuggestByDeptId(deptId);
        Integer suggestId=suggest.getSuggestId();
        PageHelper.startPage(currentPage, pagesize);
        return ideasDao.selectIdeasBySuggest(suggestId);
    }

    @Override
    public List<IdeasVo> selectIdeasBySuggestAndState(Integer empId, Integer state, int currentPage, int pagesize) {
        //根据职工id得到部门id
        Emp emp=empService.selectByPrimaryKey(empId);
        Integer deptId=emp.getDeptId();
        log.debug(emp.toString());
        //通过部门id得到意见箱id
        Suggest suggest=suggestService.selectSuggestByDeptId(deptId);
        Integer suggestId=suggest.getSuggestId();
        PageHelper.startPage(currentPage, pagesize);
        return ideasDao.selectIdeasBySuggestAndState(suggestId,state);
    }

    @Override
    public List<IdeasVo> selectIdeasByEmpIdAndState(Integer empId, Integer state) {
        return ideasDao.selectIdeasByEmpIdAndState(empId,state);
    }

    @Override
    public List<IdeasVo> selectIdeasByEmpId(Integer empId) {
        return ideasDao.selectIdeasByEmpId(empId);
    }

    @Override
    public List<IdeasVo> selectIdeasBySuggestAndEmpName(Integer empId, String empName, int currentPage, int pagesize) {
        //根据职工id得到部门id
        Emp emp=empService.selectByPrimaryKey(empId);
        Integer deptId=emp.getDeptId();
        //通过部门id得到意见箱id
        Suggest suggest=suggestService.selectSuggestByDeptId(deptId);
        Integer suggestId=suggest.getSuggestId();
        PageHelper.startPage(currentPage, pagesize);
        return ideasDao.selectIdeasBySuggestAndEmpName(suggestId,empName);
    }

    @Override
    public List<IdeasVo> selectIdeasBySuggestAndTitle(Integer empId, String ideasTitle, int currentPage, int pagesize) {
        //根据职工id得到部门id
        Emp emp=empService.selectByPrimaryKey(empId);
        Integer deptId=emp.getDeptId();
        //通过部门id得到意见箱id
        Suggest suggest=suggestService.selectSuggestByDeptId(deptId);
        Integer suggestId=suggest.getSuggestId();
        PageHelper.startPage(currentPage, pagesize);
        return ideasDao.selectIdeasBySuggestAndTitle(suggestId,ideasTitle);
    }

    @Override
    public List<IdeasVo> selectIdeasBySuggestAndReply(Integer empId, String reply, int currentPage, int pagesize) {
        //根据职工id得到部门id
        Emp emp=empService.selectByPrimaryKey(empId);
        Integer deptId=emp.getDeptId();
        //通过部门id得到意见箱id
        Suggest suggest=suggestService.selectSuggestByDeptId(deptId);
        Integer suggestId=suggest.getSuggestId();
        PageHelper.startPage(currentPage, pagesize);
        return ideasDao.selectIdeasBySuggestAndReply(suggestId,reply);
    }

    @Override
    public List<IdeasVo> selectIdeasByEmpIdAndEmpName(Integer empId, String empName) {
        return ideasDao.selectIdeasByEmpIdAndEmpName(empId,empName);
    }

    @Override
    public List<IdeasVo> selectIdeasByEmpIdAndTitle(Integer empId, String ideasTitle) {
        return ideasDao.selectIdeasByEmpIdAndTitle(empId,ideasTitle);
    }

    @Override
    public List<IdeasVo> selectIdeasByEmpIdAndReply(Integer empId, String reply) {
        return ideasDao.selectIdeasByEmpIdAndReply(empId,reply);
    }

    @Override
    public IdeasVo insertIdeas(IdeasVo ideasVo) {
        ideasVo.setTimeofpublication(new Date());
        ideasDao.insertIdeas(ideasVo);
        return ideasVo;
    }

    @Override
    public IdeasVo replyIdeas(IdeasVo ideasVo) {
        ideasVo.setRevoverytime(new Date());
        ideasVo.setState(1);
        ideasDao.replyIdeas(ideasVo);
        return ideasVo;
    }

    @Override
    public IdeasVo deleteIdeas(IdeasVo ideasVo) {
        ideasVo.setDeletetime(new Date());
        ideasVo.setTimeliness(1);
        ideasDao.deleteIdeas(ideasVo);
        return ideasVo;
    }

    @Override
    public IdeasVo noLookIdeas(IdeasVo ideasVo) {
        ideasVo.setIdeasLook(1);
        ideasDao.noLookIdeas(ideasVo);
        return ideasVo;
    }

    @Override
    public AjaxResponse deleteIdeasMany(String ids,String name) {
        String[] id=ids.split(",");
        for (String s:id){
            IdeasVo ideasVo=new IdeasVo();
            ideasVo.setIdeasId(Integer.parseInt(s));
            ideasVo.setDeletename(name);
            ideasVo.setDeletetime(new Date());
            ideasVo.setTimeliness(1);
            ideasDao.deleteIdeas(ideasVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public AjaxResponse noLookIdeasMany(String ids) {
        String[] id=ids.split(",");
        for(String s:id){
            IdeasVo ideasVo=new IdeasVo();
            ideasVo.setIdeasId(Integer.parseInt(s));
            ideasVo.setIdeasLook(1);
            ideasDao.noLookIdeas(ideasVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public List<IdeasVo> selectAllIdeasByEmpName(String empname) {
        return ideasDao.selectAllIdeasByEmpName(empname);
    }

    @Override
    public List<IdeasVo> selectAllIdeasByTitle(String title) {
        return ideasDao.selectAllIdeasByTitle(title);
    }

    @Override
    public List<IdeasVo> selectAllIdeasByState(Integer state) {
        return ideasDao.selectAllIdeasByState(state);
    }

    @Override
    public List<IdeasVo> selectAllIdeasBySuggestName(String suggestname) {
        return ideasDao.selectAllIdeasBySuggestName(suggestname);
    }
}
