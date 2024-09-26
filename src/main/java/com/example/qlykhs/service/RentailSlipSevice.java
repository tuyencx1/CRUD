package com.example.qlykhs.service;

import com.example.qlykhs.dto.RentailSlipDto;
import com.example.qlykhs.dto.respon.RentalSlipAddDto;
import com.example.qlykhs.dto.respon.RentalSlipResutDto;
import com.example.qlykhs.entity.*;
import com.example.qlykhs.repositoty.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentailSlipSevice {
    private final RentalSlipReponsitory rentalSlipReponsitory;
    private final StaffReponsitory staffReponsitory;
    private final CustomerReponsitory customerReponsitory;
    private final InvoiceSeponsitory invoiceSeponsitory;
    private final RoomListReponsitory roomListReponsitory;
    private final ServiceReponsitory serviceReponsitory;
    private final ServiceListReponsitory serviceListReponsitory;
    private final RoomReponsitory roomReponsitory;

    public RentailSlipSevice(RentalSlipReponsitory rentalSlipReponsitory, StaffReponsitory staffReponsitory, CustomerReponsitory customerReponsitory, InvoiceSeponsitory invoiceSeponsitory, RoomListReponsitory roomListReponsitory, ServiceReponsitory serviceReponsitory, ServiceListReponsitory serviceListReponsitory, RoomReponsitory roomReponsitory) {
        this.rentalSlipReponsitory = rentalSlipReponsitory;
        this.staffReponsitory = staffReponsitory;
        this.customerReponsitory = customerReponsitory;
        this.invoiceSeponsitory = invoiceSeponsitory;
        this.roomListReponsitory = roomListReponsitory;
        this.serviceReponsitory = serviceReponsitory;
        this.serviceListReponsitory = serviceListReponsitory;
        this.roomReponsitory = roomReponsitory;
    }

    public boolean check(String id) {
        Optional<RentalSlip> rentalSlip = rentalSlipReponsitory.findById(id);
        return rentalSlip.isPresent();
    }

    public List<RentalSlip> getAll() {
        return rentalSlipReponsitory.findAll();
    }

    public List<RentailSlipDto> getfindById(String id) {
        return rentalSlipReponsitory.findRentalSlipDto(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public RentalSlipResutDto addRentalSlip(RentalSlipAddDto rentalSlipAddDto) {
        Staff staff = staffReponsitory.findById(rentalSlipAddDto.getStaffId()).orElseThrow(() -> new RuntimeException("Staff not found"));
        Customer customer = customerReponsitory.findById(rentalSlipAddDto.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        Services service = serviceReponsitory.findById(rentalSlipAddDto.getServiceId()).orElseThrow(() -> new RuntimeException("Service not found"));
        Room room = roomReponsitory.findById(rentalSlipAddDto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        RentalSlip rentalSlip = new RentalSlip(rentalSlipAddDto.getRentalSlipId(), rentalSlipAddDto.getStartDate(), rentalSlipAddDto.getEndDate(),rentalSlipAddDto.getRoomNumber(), rentalSlipAddDto.getCustomerNumber(), rentalSlipAddDto.getDeposit(), rentalSlipAddDto.getStaffId(), rentalSlipAddDto.getCustomerId());
        rentalSlipReponsitory.save(rentalSlip);
        ServiceList svl = new ServiceList(rentalSlipAddDto.getRentalSlipId(),rentalSlipAddDto.getServiceId(),rentalSlipAddDto.getNumber());
        serviceListReponsitory.save(svl);
        roomListReponsitory.save(new RoomList(rentalSlipAddDto.getRentalSlipId(),rentalSlipAddDto.getRoomId()));
        return new RentalSlipResutDto(rentalSlip, staff, customer, service,rentalSlipAddDto.getNumber() , room);
    }

    public RentalSlip updateRentalSlip(String id ,RentailSlipDto rentalSlipDto){
        RentalSlip rentalSlip = rentalSlipReponsitory.findById(id).orElseThrow(() -> new RuntimeException("RentalSlip not found"));
        rentalSlip.setStartDate(rentalSlipDto.getStartDate());
        rentalSlip.setEndDate(rentalSlipDto.getEndDate());
        rentalSlip.setRoomNumber(rentalSlipDto.getRoomNumber());
        rentalSlip.setCustomerNumber(rentalSlipDto.getCustomerNumber());
        rentalSlip.setDeposit(rentalSlipDto.getDeposit());
        rentalSlip.setStaffId(rentalSlipDto.getStaffId());
        rentalSlip.setCustomerId(rentalSlipDto.getCustomerId());
        rentalSlipReponsitory.save(rentalSlip);
        return rentalSlip;
    }
    public void deleteRentalSlip(String id){
        serviceListReponsitory.deleteByRentalSlipId(id);
        roomListReponsitory.deleteByRentalSlipId(id);
        invoiceSeponsitory.deleteByRentalSlipId(id);
        rentalSlipReponsitory.deleteById(id);
    }
}
