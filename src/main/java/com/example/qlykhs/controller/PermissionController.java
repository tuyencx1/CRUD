package com.example.qlykhs.controller;

import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.entity.Permission;
import com.example.qlykhs.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/per")
@AllArgsConstructor
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/")
    public ResponseEntity<ResponsiData> getPermission() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData<>(permissionService.GetAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponsiData> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponsiData<>("Success","Creat Permission Success",permissionService.Create(permission)));
    }

    @DeleteMapping("/delete/{name}")
    public String deletePermission(@PathVariable String name) {
        permissionService.delete(name);
        return "Delete Permission Success";
    }
}
