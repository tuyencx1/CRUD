package com.example.qlykhs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;
    private String customerName;
    private String profession;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean gender;
    private int phoneNumber;
    private int idCard;
    private String user;
    private String password;

    @ManyToMany
    private List<Role> roles;

}
