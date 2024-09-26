package com.example.qlykhs.controller;

import com.example.qlykhs.dto.Resquest.RoleResquest;
import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResponseEntity<ResponsiData> getRole() {
        List<Role> roles = roleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData(roles));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponsiData> addRole(@RequestBody RoleResquest role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponsiData<>("Success","Creat data role",roleService.CreateRole(role)));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponsiData> updateRole(@PathVariable String id,@RequestBody RoleResquest role) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponsiData<>("Success","Update data role",roleService.UpdateRole(id, role)));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.DeleteRole(id);
        return "Deleted user with id " + id;
    }
}
