package com.trkj.tsm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;

@Validated
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseVo {
    /**
     * 企业档案编号
     */
    private Integer enterpriseId;

    /**
     * 企业全称
     */
    private String enterpriseName;

    /**
     * 企业品牌
     */
    private String enclosureBrand;

    /**
     * 企业简称
     */
    private String enterpriseShortname;

    /**
     * 英文名称
     */
    private String enterpriseEnglishname;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 公司类型
     */
    private String companytype;

    /**
     * 邮政编码
     */
    private Integer postalcode;

    /**
     * 公司地址
     */
    private String companyaddress;

    /**
     * 公司电话
     */
    private Integer companyphone;

    /**
     * 传值号码
     */
    private String faxphone;

    /**
     * 公司网站
     */
    private String comanyweb;

    /**
     * 电子邮箱
     */
    private String eMail;

    /**
     * 法人代表
     */
    private String representative;

    /**
     * 注册时间
     */
    private Date registertime;

    /**
     * 注册资金
     */
    private BigDecimal registermoney;

    /**
     * 员工数量
     */
    private Integer empnumber;

    /**
     * 开户银行
     */
    private String depositBank;

    /**
     * 银行账号
     */
    private String bankNumber;

    /**
     * 企业简介
     */
    private String enterpriseBrief;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;
}
