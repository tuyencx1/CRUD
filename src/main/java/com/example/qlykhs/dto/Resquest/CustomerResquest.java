package com.example.qlykhs.dto.Resquest;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResquest {


    private String customerName;
    private String profession;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean gender;
    private int phoneNumber;
    private int idCard;
    private String user;
    private String password;

    private List<String> roles;
}
