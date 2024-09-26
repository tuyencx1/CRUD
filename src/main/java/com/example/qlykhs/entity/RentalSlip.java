package com.example.qlykhs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rentalslip")
public class RentalSlip {
    @Id
    private String rentalSlipId;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private int roomNumber;

    private int customerNumber;

    private long deposit;

    @Column (name = "staffId")
    private String staffId;

    @Column (name = "customerId")
    private  String customerId;
}
