package com.example.qlykhs.controller;

import com.example.qlykhs.dto.Resquest.StaffResquest;
import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public ResponseEntity<ResponsiData> getStaff() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData("200","Get All Staff",staffService.findAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponsiData> addStaff(@RequestBody StaffResquest staff) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsiData("200","Add Staff",staffService.addStaff(staff)));
    }
}
