package com.example.qlykhs.dto.respon;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private String serviceId;
    private String serviceName;
    private double price;
}
