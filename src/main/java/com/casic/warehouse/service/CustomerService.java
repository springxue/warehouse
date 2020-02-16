package com.casic.warehouse.service;

import com.casic.warehouse.bean.Customer;
import com.casic.warehouse.bean.User;
import com.casic.warehouse.bean.query.CustomerQuery;
import com.casic.warehouse.dao.CustomerDao;
import com.casic.warehouse.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    /**
     * 获取客户分页数据
     * @param customerQuery  查询条件
     * @return 客户列表
     */
    public List<Customer> getPageList(CustomerQuery customerQuery) {
        return customerDao.getPageList(customerQuery);
    }

    public Long getTotal(CustomerQuery customerQuery) {
        return customerDao.getTotal(customerQuery);
    }

    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    public Long deleteCustomersByIds(List<Long> ids) {
        return customerDao.deleteCustomersByIds(ids);
    }
}
