package com.casic.warehouse.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private Long count; //总条数
    private List<T> data; //装前台当前页的数据
}
