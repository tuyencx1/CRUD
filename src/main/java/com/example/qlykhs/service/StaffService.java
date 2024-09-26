package com.example.qlykhs.service;

import com.example.qlykhs.dto.Resquest.StaffResquest;
import com.example.qlykhs.dto.respon.StaffRespon;
import com.example.qlykhs.entity.Staff;
import com.example.qlykhs.mapper.StaffMapper;
import com.example.qlykhs.repositoty.StaffReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StaffService {
    @Autowired
    private StaffReponsitory staffReponsitory;
    @Autowired
    private StaffMapper staffMapper;

    public List<Staff> findAll() { return staffReponsitory.findAll(); }

    public StaffRespon addStaff(StaffResquest staff) {
        if(staffReponsitory.existsById(staff.getStaffId())) {
            throw new RuntimeException("Staff name already exists");
        }else{
            Staff staff1 = staffMapper.toStaff(staff);
            return staffMapper.toStaffResponse(staffReponsitory.save(staff1));
        }
    }
}
