package com.casic.warehouse.dao;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.query.CustomerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
   //根据条件查询获取分页
   public List<Customer> getPageList(CustomerQuery customerQuery);
   //获取总数
   public Long getTotal(CustomerQuery customerQuery);
   //添加客户
   public boolean addCustomer(Customer customer);
   //根据id获取用户信息
   public Customer getCustomerById(@Param("id") Long id);
   //修改客户信息
   public boolean updateCustomer(Customer customer);
   //根据id批量删除客户
   public Long deleteCustomersByIds(List<Long> ids);
}
