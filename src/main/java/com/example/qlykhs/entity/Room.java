package com.example.qlykhs.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Room")
public class Room {
    @Id
    private String roomId;
    private int roomNumber;
    private int bedNumber;
    private boolean status;
    private double price;

    @Column(name = "roomTypeId")
    private String roomTypeId;

}
