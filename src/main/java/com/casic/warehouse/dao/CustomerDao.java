package com.casic.warehouse.dao;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.query.CustomerQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
   public List<Customer> getPageList(CustomerQuery customerQuery);

   public Long getTotal(CustomerQuery customerQuery);
}
