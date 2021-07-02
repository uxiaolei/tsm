package com.trkj.tsm.service;

import com.trkj.tsm.dao.CourserecorddetailsDao;
import com.trkj.tsm.dao.DropoutDao;
import com.trkj.tsm.dao.RefundDao;
import com.trkj.tsm.entity.Courserecorddetails;
import com.trkj.tsm.entity.Dropout;
import com.trkj.tsm.entity.Refund;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.BackVo;
import com.trkj.tsm.vo.CourserecorddetailsVo;
import com.trkj.tsm.vo.DropoutVo;
import com.trkj.tsm.vo.RefundVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RefundServiceImpl implements RefundService {
    @Resource
    private RefundDao refundDao;

    @Override
    public List<Refund> seleAllRefund(String classesName) {
        return refundDao.seleAllRefund(classesName);
    }

    @Override
    public int addRefund1(BackVo backVo) {
        Refund refund=new Refund();
       refund.setAddname(backVo.backHandler);
       refund.setClassesId(backVo.getClassesId());
       refund.setCourseId(backVo.getCourseId());

       refund.setRefundtype("复课回退");

        return refundDao.insertSelective(refund);
    }

//    @Override
//    public Refund addRefund(Refund refund) {
//        RefundVo ref=new RefundVo();
//      //  refund.setAddname("xl");
//        refund.setDropMoney(BigDecimal.valueOf(100.000));
//        BeanCopyUtil.copyProperties(refund,ref);
//        refundDao.insertSelective(refund);
//        return refund;
//    }

    @Override
    public int delRefund(Integer refundId) {
        Refund ref=new Refund();
        ref.setRefundId(refundId);
        ref.setDeletename("xl");
        ref.setTimeliness(1);
        ref.setDeletetime(new Date());
        return refundDao.updateByPrimaryKeySelective(ref);
    }

    @Override
    public int upcwApproval(Refund refund) {
        return refundDao.upcwApproval(refund);
    }

}
