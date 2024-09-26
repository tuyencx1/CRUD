package com.example.qlykhs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roomtype")
public class RoomType {

    @Id
    private String roomTypeId;
    private String roomTypeName;
}
