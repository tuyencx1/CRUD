package com.example.qlykhs.dto.Resquest;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffResquest {
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
