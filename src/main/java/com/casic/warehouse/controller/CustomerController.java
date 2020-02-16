package com.casic.warehouse.controller;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.query.CustomerQuery;
import com.casic.warehouse.common.Result;
import com.casic.warehouse.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("customerLayer")
    public String customerLayer(@RequestParam(required = false,value = "id") Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        System.out.println(customer);
        model.addAttribute("customer",customer);
        return "views/customer/customerLayer";
    }


    @RequestMapping("getPageList")
    @ResponseBody
    public Result getPageList(@RequestBody CustomerQuery customerQuery){
        System.out.println(customerQuery);
        customerQuery.setPage(customerQuery.getPage()-1);
        List<Customer> customerList=customerService.getPageList(customerQuery);
        Long count=customerService.getTotal(customerQuery);
        Result result= new Result();
        result.setCode(0);
        result.setCount(count);
        result.setData(customerList);
        return result;
    }

    @RequestMapping("addOrUpdateCustomer")
    @ResponseBody
    public Result addOrUpdateCustomer( @RequestBody Customer customer){

        boolean flag;
        if(StringUtils.isEmpty(customer.getId())){
            flag=customerService.addCustomer(customer);
        }else {
            try{
                flag=customerService.updateCustomer(customer);
            }catch (Exception e){
                e.printStackTrace();
                return Result.error().msg(e.getMessage());
            }
            flag=customerService.updateCustomer(customer);
        }

        if(flag){
            return Result.ok();
        }
        return Result.error();
    }

    @RequestMapping("getCustomer")
    @ResponseBody
    public Result getCustomer(Long id){
        Customer customer=customerService.getCustomerById(id);
        if(customer==null){
            return Result.error().msg("没有找到该客户");
        }
        return Result.ok().Data(customer);
    }

    @RequestMapping("deleteCustomersByIds")
    @ResponseBody
    public Result deleteCustomersByIds(@RequestBody List<Long> ids){
        Long count=customerService.deleteCustomersByIds(ids);
        if(count==ids.size()){
            return Result.ok().msg("成功删除"+count+"条记录");
        }
        return Result.error();
    }
}
