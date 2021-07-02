package com.trkj.tsm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ArrangeFormVo {
    private Integer classRoomId;
    private List<Integer> classesId;
    private String date;
    private Integer periodId;
    private Integer newClassesId;
    private Integer tercherId;
    private String addname;
}
