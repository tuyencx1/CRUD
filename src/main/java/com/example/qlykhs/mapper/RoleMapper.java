package com.example.qlykhs.mapper;

import com.example.qlykhs.dto.Resquest.CustomerResquest;
import com.example.qlykhs.dto.Resquest.RoleResquest;
import com.example.qlykhs.dto.respon.CustomerRespon;
import com.example.qlykhs.dto.respon.RoleRespon;
import com.example.qlykhs.entity.Customer;
import com.example.qlykhs.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleResquest resquest);

    RoleRespon toRoleResponse(Role role);

    @Mapping(target = "permissions", ignore = true)
    void updateRole(@MappingTarget Role role,RoleResquest resquest);
}
