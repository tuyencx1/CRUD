package com.example.qlykhs.dto.respon;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalSlipAddDto {
    String rentalSlipId;
    @Temporal(TemporalType.DATE)
    Date startDate;
    @Temporal(TemporalType.DATE)
    Date endDate;
    int roomNumber;
    int customerNumber;
    long deposit;
    String staffId;
    String customerId;
    String serviceId;
    int number;
    String roomId;
}
