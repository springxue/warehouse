package com.casic.warehouse.controller;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.query.CustomerQuery;
import com.casic.warehouse.common.R;
import com.casic.warehouse.common.Result;
import com.casic.warehouse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客戶管理
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("list")
    public String list(){
        return "views/customer/customerList";
    }


    @RequestMapping("getPageList")
    @ResponseBody
    public Result<Customer> getPageList(@RequestBody CustomerQuery customerQuery){
        customerQuery.setPage(customerQuery.getPage()-1);
        List<Customer> customerList=customerService.getPageList(customerQuery);
        Long count=customerService.getTotal(customerQuery);
        Result<Customer> result= new Result<Customer>();
        result.setCode(0);
        result.setCount(count);
        result.setData(customerList);
        return result;
    }
}
