package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Permission;
import com.example.qlykhs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionReponsitory extends JpaRepository<Permission, String> {
    boolean existsByName(String name);

   Permission findByName(String name);
}
