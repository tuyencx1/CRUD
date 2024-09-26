package com.example.qlykhs.service;

import com.example.qlykhs.entity.Services;
import com.example.qlykhs.repositoty.ServiceReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    @Autowired
    private ServiceReponsitory serviceReponsitory;

    public ServiceService(ServiceReponsitory serviceReponsitory) {
        this.serviceReponsitory = serviceReponsitory;
    }

    public boolean check(String id){
        Optional<Services> list =  serviceReponsitory.findById(id);
        return list.isPresent() ;}

    public List<Services> getAll() {
        return serviceReponsitory.findAll();
    }

    public void delete(String id){
         serviceReponsitory.deleteById(id);
    }

    public List<Services> search(double price){
        return serviceReponsitory.findpricelessthanX(price);
    }
}
