package com.example.qlykhs.entity;

import com.example.qlykhs.entity.key.KeyRoomList;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Roomlist")
public class RoomList {
    @EmbeddedId
    KeyRoomList keyRoomList;

    @Column(name = "rentalSlipId",insertable = false,updatable = false)
    private String rentalSlipId;

    @Column(name = "roomId",insertable = false,updatable = false)
    private String roomId;

    public RoomList( String rentalSlipId, String roomId) {
        this.keyRoomList = new KeyRoomList(rentalSlipId,roomId);
        this.rentalSlipId = rentalSlipId;
        this.roomId = roomId;
    }
}
