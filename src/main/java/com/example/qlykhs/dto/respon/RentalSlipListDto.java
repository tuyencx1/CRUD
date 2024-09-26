package com.example.qlykhs.dto.respon;

import com.example.qlykhs.entity.Customer;
import com.example.qlykhs.entity.Staff;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentalSlipListDto {
    private String rentalSlipId;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private int roomNumber;
    private int customerNumber;
    private long deposit;
    private Staff staffId;
    private Customer customerId;
}
