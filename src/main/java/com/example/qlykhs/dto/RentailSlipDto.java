package com.example.qlykhs.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentailSlipDto {
    private String rentalSlipId;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private int roomNumber;
    private int customerNumber;
    private long deposit;
    private String staffId;
    private String staffName;
    private String customerId;
    private String customerName;
    private String invoiceId;
    @Temporal(TemporalType.DATE)
    private Date creatDate;

}
