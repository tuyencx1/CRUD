package com.example.qlykhs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    private String invoiceId;

    @Temporal(TemporalType.DATE)
    private Date creatDate;


    @Column(name = "staffId")
    private String staffId;

    @Column(name = "rentalSlipId")
    private String rentalSlipId;
}
