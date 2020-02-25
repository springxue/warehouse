package com.casic.warehouse.bean.query;

import lombok.Data;

/**
 * 客户查询条件
 */
@Data
public class CustomerQuery {
    private String customername;
    private String telephone;
    private String connectionperson;
    //当前页
    private int page;
    //每页显示的条数
    private String limit;
}
