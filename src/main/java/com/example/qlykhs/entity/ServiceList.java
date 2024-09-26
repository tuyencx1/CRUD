package com.example.qlykhs.entity;

import com.example.qlykhs.entity.key.KeyListService;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Sercivelist")

public class ServiceList {
    @EmbeddedId
    private KeyListService keyListService;

    @Column (name = "rentalSlipId" ,insertable=false, updatable=false)
    private String rentalSlipId;

    @Column (name = "serviceId",insertable=false, updatable=false)
    private String serviceId;

    private int number;

    public ServiceList( String rentalSlipId, String serviceId, int number) {
        this.keyListService = new KeyListService(rentalSlipId,serviceId);
        this.rentalSlipId = rentalSlipId;
        this.serviceId = serviceId;
        this.number = number;
    }
}
