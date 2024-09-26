package com.example.qlykhs.entity.key;

import com.example.qlykhs.entity.RentalSlip;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class KeyRoomList implements Serializable {
    @Column(name = "rentalSlipId")
    private String rentalSlip;
    @Column(name = "roomId")
    private String roomId;
}
