package com.example.qlykhs.service;

import com.example.qlykhs.dto.respon.CustomerRespon;
import com.example.qlykhs.dto.Resquest.CustomerResquest;
import com.example.qlykhs.entity.Customer;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.mapper.CustomerMapper;
import com.example.qlykhs.repositoty.CustomerReponsitory;
import com.example.qlykhs.repositoty.RoleReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    @Autowired
    private CustomerReponsitory customerReponsitory;
    @Autowired
    public CustomerMapper customerMapper;
    @Autowired
    private RoleReponsitory roleReponsitory;

    public Customer GetFindById(String id) { return customerReponsitory.findById(id).orElseThrow(()
            -> new RuntimeException("Customer Not Found"));}

    public boolean check(String id){return customerReponsitory.findById(id).isPresent();}

    public List<Customer> getAllCustomer(){return customerReponsitory.findAll();}

    public void deleteCustomer(String id){
        if(!check(id)){
            throw new RuntimeException("Customer Not Found");
        }else customerReponsitory.deleteById(id);}

    public List<Customer> searchCustomer(String user){return customerReponsitory.findByUserContaining(user);}

    public CustomerRespon creatCustomer(CustomerResquest resquest){
        if(customerReponsitory.existsByUser(resquest.getUser())){
            throw new RuntimeException("Username already exists");
        }else
        {
            Customer customer = customerMapper.toCustomer(resquest);
            List<Role> roles = roleReponsitory.findAllById(resquest.getRoles());
            customer.setRoles(roles);
            return customerMapper.toCustomerResponse(customerReponsitory.save(customer));
        }
    }

    public CustomerRespon updateCustomer(String id,CustomerResquest resquest){
        if(check(id)){

            Customer customer = GetFindById(id);
            customerMapper.updateCustomer(customer,resquest);
            List<Role> roles = roleReponsitory.findAllById(resquest.getRoles());
            customer.setRoles(roles);
            return customerMapper.toCustomerResponse(customerReponsitory.save(customer));
        }else {
            throw new RuntimeException("User does not exist");
        }
    }
}
