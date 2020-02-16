package com.casic.warehouse.dao;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.query.CustomerQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
   public List<Customer> getPageList(CustomerQuery customerQuery);

   public Long getTotal(CustomerQuery customerQuery);

   public boolean addCustomer(Customer customer);

   public Customer getCustomerById(@Param("id") Long id);

   public boolean updateCustomer(Customer customer);

   public Long deleteCustomersByIds(List<Long> ids);
}
