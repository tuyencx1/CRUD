package com.example.qlykhs.controller;

import com.example.qlykhs.dto.RentailSlipDto;
import com.example.qlykhs.dto.respon.RentalSlipAddDto;
import com.example.qlykhs.dto.respon.RentalSlipListDto;
import com.example.qlykhs.dto.respon.RentalSlipResutDto;
import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.entity.RentalSlip;
import com.example.qlykhs.service.RentailSlipSevice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalslip")
@AllArgsConstructor
public class RentalSlipController {
    @Autowired
    private RentailSlipSevice rentailSlipSevice;

    @GetMapping("/all")
    public ResponseEntity<ResponsiData> getAllRentalSlips() {
      List<RentalSlip> rentalSlips = rentailSlipSevice.getAll();
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponsiData("OK","Get all RentalSlips",rentalSlips)
      );
    }

    @PutMapping("/{rentalSlipId}")
    public ResponseEntity<ResponsiData> getById(@PathVariable String rentalSlipId){
        if (rentailSlipSevice.check(rentalSlipId)){
        List<RentailSlipDto> list = rentailSlipSevice.getfindById(rentalSlipId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData("ok","",list));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsiData("not found","Khong ton tai id "+rentalSlipId,null));
        }
    }

    @PostMapping("/add")
    private ResponseEntity<ResponsiData> addRentalSlip(@RequestBody RentalSlipAddDto rentalSlipAddDto){
        if (rentailSlipSevice.check(rentalSlipAddDto.getRentalSlipId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                   new ResponsiData<>(HttpStatus.BAD_REQUEST.toString(),"Id: "+rentalSlipAddDto.getRentalSlipId()+ " đã có !",""));
        }else {
            RentalSlipResutDto rentailSlip = rentailSlipSevice.addRentalSlip(rentalSlipAddDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponsiData("ok","Thêm thành công",rentailSlip)
            );
        }
    }

    @PutMapping("/update/{id}")
    public ResponsiData<?> updateRentalSlip(@PathVariable String id,@RequestBody RentailSlipDto rentalSlip) {
        ResponsiData responsiData = new ResponsiData();
        if (rentailSlipSevice.check(id)) {
            responsiData.setData(rentailSlipSevice.updateRentalSlip(id, rentalSlip));
            responsiData.setMessage("Cập nhật thành công !");
        } else {
            responsiData.setMessage("Không tồn tại id : " + id);
        }
        return responsiData;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponsiData> deleteRentalSlip(@PathVariable String id) {
        if (rentailSlipSevice.check(id)) {
            rentailSlipSevice.deleteRentalSlip(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponsiData(HttpStatus.OK.toString(),"Xoá thành công",""));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponsiData(HttpStatus.BAD_REQUEST.toString(),"Không tồn tại id : "+id,""));
        }

    }
}
