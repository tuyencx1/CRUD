package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleReponsitory extends JpaRepository<Role, String> {
    List<Role> findByName(String roleName);

    boolean existsByName(String roleName);

//    List<Role> findByPermissions(String name);
}
