package com.example.qlykhs.dto.respon;

import com.example.qlykhs.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRespon {

    private String name;

    private String description;

    private List<Permission> permissions;
}
