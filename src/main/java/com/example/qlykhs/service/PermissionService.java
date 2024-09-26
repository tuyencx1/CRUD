package com.example.qlykhs.service;


import com.example.qlykhs.entity.Permission;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.repositoty.PermissionReponsitory;
import com.example.qlykhs.repositoty.RoleReponsitory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissionService {
    @Autowired
    private PermissionReponsitory permissionReponsitory;
    @Autowired
    private RoleReponsitory roleReponsitory;

    public List<Permission> GetAll(){
        return permissionReponsitory.findAll();
    }

    public Permission Create(Permission resquest){
        if(permissionReponsitory.existsByName(resquest.getName())){
            throw new RuntimeException("Permissinon Name already exists");
        }else{
            return permissionReponsitory.save(resquest);
        }
    }
    public void delete(String name) {
        if(permissionReponsitory.existsByName(name)){
          Permission permission = permissionReponsitory.findByName(name);
            permissionReponsitory.deleteById(name);
        }else
            throw new RuntimeException("Permissinon Name does not exist");
    }
}
