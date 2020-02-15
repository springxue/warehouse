package com.casic.warehouse.bean;

import lombok.Data;

/**
 * 客户
 */
@Data
public class Customer {
    //客户编号
    private Long id;
    //客户名称
    private String customername;
    //客户邮编
    private String zip;
    //客户地址
    private String address;
    //客户电话
    private String telephone;
    //联系人
    private String connectionperson;
    //联系人电话
    private String phone;
    //开户行
    private String bank;
    //账号
    private String account;
    //邮箱
    private String email;
    //传真
    private String fax;
    //是否有效
    private Long available;
}
