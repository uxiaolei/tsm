package com.trkj.tsm.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuVo {
    private int id;
    private int menuPid;
    private String menuPids;
    private byte isLeaf;
    private String menuName;
    private String url;
    private String icon;
    private String iconColor;
    private Byte sort;
    private byte level;
    private byte status;
}
