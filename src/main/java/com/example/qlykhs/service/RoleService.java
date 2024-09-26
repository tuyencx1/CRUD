package com.example.qlykhs.service;

import com.example.qlykhs.dto.Resquest.RoleResquest;
import com.example.qlykhs.dto.respon.RoleRespon;
import com.example.qlykhs.entity.Permission;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.mapper.RoleMapper;
import com.example.qlykhs.repositoty.PermissionReponsitory;
import com.example.qlykhs.repositoty.RoleReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    @Autowired
    private RoleReponsitory roleReponsitory;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionReponsitory permissionReponsitory;

    public List<Role> getAll(){return roleReponsitory.findAll();}

    public RoleRespon CreateRole(RoleResquest resquest){
        if(roleReponsitory.existsByName(resquest.getName())){
            throw new RuntimeException("Rolename already exists");
        }else{
            Role role = roleMapper.toRole(resquest);
            List<Permission> permissions = permissionReponsitory.findAllById(resquest.getPermissions());
            role.setPermissions(permissions);
            return roleMapper.toRoleResponse(roleReponsitory.save(role));
        }
    }

    public RoleRespon UpdateRole(String id,RoleResquest resquest){
        if(roleReponsitory.existsByName(resquest.getName())){
            Role role = GetFindById(id);
            roleMapper.updateRole(role,resquest);
            List<Permission> permissions = permissionReponsitory.findAllById(resquest.getPermissions());
            role.setPermissions(permissions);
            return roleMapper.toRoleResponse(roleReponsitory.save(role));
        }else {
            throw new RuntimeException("Rolename already exists");
        }
    }

    public void DeleteRole(String id){
        if(roleReponsitory.existsByName(id)){
            roleReponsitory.deleteById(id);
        }else throw new RuntimeException("Customer Not Found");
    }


    public Role GetFindById(String id) { return roleReponsitory.findById(id).orElseThrow(()
            -> new RuntimeException("Role Not Found"));
    }



}
