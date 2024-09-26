package com.example.qlykhs.dto.respon;

import com.example.qlykhs.entity.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalSlipResutDto {
    private RentalSlip rentalSlipist;
    private Staff staff;
    private Customer customer;
    private Services service;
    private int number;
    private Room room;
}
