package com.example.qlykhs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission {
    @Id
    private String name;

    private String description;
}
