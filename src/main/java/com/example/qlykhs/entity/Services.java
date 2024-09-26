package com.example.qlykhs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service")
public class Services {
    @Id
    private String serviceId;
    private String serviceName;
    private double price;
}
