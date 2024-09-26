package com.example.qlykhs.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class KeyListService implements Serializable {
    @Column(name = "serviceId")
    private String serviceId;
    @Column(name = "rentalSlipId")
    private String rentalSlipId;

}
