package com.trkj.tsm.service;


import com.trkj.tsm.entity.Classtype;
import com.trkj.tsm.vo.ClasstypeVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClasstypeService {
        public List<ClasstypeVo> selectClasstypes();
        Classtype addClasstypes(Classtype classtype);
        int updateClasstypes(ClasstypeVo classtypeVo);
        int deleteByClasstypesId(Integer classtypeId);
}
