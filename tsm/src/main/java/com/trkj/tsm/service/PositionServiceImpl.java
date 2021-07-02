package com.trkj.tsm.service;

import com.trkj.tsm.dao.PositionDao;
import com.trkj.tsm.vo.AjaxResponse;
import com.trkj.tsm.vo.PositionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    @Override
    public List<PositionVo> selectAllPosition() {
        return positionDao.selectAllPosition();
    }

    @Override
    public PositionVo insertPosition(PositionVo positionVo) {
        positionVo.setAddname("梁政");
        positionVo.setAddtime(new Date());
        positionDao.insertPosition(positionVo);
        return positionVo;
    }

    @Override
    public PositionVo updatePosition(PositionVo positionVo) {
        positionVo.setUpdatename("梁政");
        positionVo.setUpdatetime(new Date());
        positionDao.updatePosition(positionVo);
        return positionVo;
    }

    @Override
    public PositionVo deletePosition(PositionVo positionVo) {
        positionVo.setDeletename("梁政");
        positionVo.setDeletetime(new Date());
        positionDao.deletePosition(positionVo);
        return positionVo;
    }

    @Override
    public AjaxResponse deletePositionMany(String ids) {
        String[] id = ids.split(",");
        for (String s : id) {
            PositionVo positionVo = new PositionVo();
            positionVo.setDeletetime(new Date());
            positionVo.setDeletename("梁政");
            positionVo.setTimeliness(1);
            positionVo.setPositionId(Integer.parseInt(s));
            positionDao.deletePosition(positionVo);
        }
        return AjaxResponse.success();
    }

    @Override
    public List<PositionVo> selectPositionByName(String positionName) {
        return positionDao.selectPositionByName(positionName);
    }
}
