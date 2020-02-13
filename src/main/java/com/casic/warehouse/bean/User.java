package com.casic.warehouse.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private String loginName;
    private String address;
    private Integer gender;
    private String remark;
    private String pwd;
    private Long deptId;
    private Date hireDate;
    private Long mgr;
    private Long available;
    private Long orderNum;
    private Long type;
    private String imgPath;
    private String salt;
}
