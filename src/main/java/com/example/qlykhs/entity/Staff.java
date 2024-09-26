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
@Table(name = "Staff")
public class Staff {
    @Id
    private String staffId;
    private String staffName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean gender;
    private String address;
    private int phoneNumber;
    private int idCard;
    private float salaryRank;
    private String position;

}
