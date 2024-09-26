package com.example.qlykhs.mapper;

import com.example.qlykhs.dto.Resquest.RoleResquest;
import com.example.qlykhs.dto.Resquest.StaffResquest;
import com.example.qlykhs.dto.respon.RoleRespon;
import com.example.qlykhs.dto.respon.StaffRespon;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    Staff toStaff(StaffResquest resquest);

    StaffRespon toStaffResponse(Staff staff);

    void updateStaff(@MappingTarget Staff staff,StaffResquest resquest);
}
