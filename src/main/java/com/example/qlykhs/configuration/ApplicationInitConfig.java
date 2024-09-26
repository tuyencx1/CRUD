package com.example.qlykhs.configuration;

import com.example.qlykhs.entity.Customer;
import com.example.qlykhs.entity.Role;
import com.example.qlykhs.repositoty.CustomerReponsitory;
import com.example.qlykhs.repositoty.RoleReponsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {

    @Bean
    ApplicationRunner applicationRunner(CustomerReponsitory customerReponsitory, RoleReponsitory roleReponsitory) {
        return args -> {
            if(customerReponsitory.findByUser("admin").isEmpty()){
                List<Role> roles = roleReponsitory.findByName("ADMIN");
                Customer customer = Customer.builder()
                        .user("admin")
                        .password("admin")
                        .roles(roles)
                        .build();
                customerReponsitory.save(customer);
                log.warn("User admin has been created with account and password: admin");
            }
        };
    }
}
