package com.example.qlykhs.controller;

import com.example.qlykhs.dto.Resquest.CustomerResquest;
import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.entity.Customer;
import com.example.qlykhs.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cus")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public ResponseEntity<ResponsiData> getCustomers() {
        List<Customer> customerList = customerService.getAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponsiData<>("success","Get All Customer",customerList));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponsiData> addCustomer(@RequestBody CustomerResquest customer) {
       return ResponseEntity.status(HttpStatus.CREATED).body(
               new ResponsiData<>("success","Add Customer",customerService.creatCustomer(customer)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponsiData> updateCustomer(@PathVariable String id,@RequestBody CustomerResquest customer) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponsiData<>("success","Update Customer",customerService.updateCustomer(id,customer)));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "Deleted user with id " + id;
    }
    @PutMapping("/")
    public ResponseEntity<ResponsiData> findUserCustomer(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData<>(customerService.searchCustomer(user)));
    }

}
