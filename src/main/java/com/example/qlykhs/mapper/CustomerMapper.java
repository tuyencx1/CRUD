package com.example.qlykhs.mapper;

import com.example.qlykhs.dto.respon.CustomerRespon;
import com.example.qlykhs.dto.Resquest.CustomerResquest;
import com.example.qlykhs.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "roles", ignore = true)
    Customer toCustomer(CustomerResquest resquest);

    CustomerRespon toCustomerResponse(Customer user);

    @Mapping(target = "roles", ignore = true)
    void updateCustomer(@MappingTarget Customer customer, CustomerResquest request);
}
