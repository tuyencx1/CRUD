package com.example.qlykhs.dto.respon;

import com.example.qlykhs.entity.Services;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceListDto {
    private List<Services> serviceList;


}
