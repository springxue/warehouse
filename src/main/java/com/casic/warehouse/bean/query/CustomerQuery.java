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
    private int page;
    private String limit;
}
