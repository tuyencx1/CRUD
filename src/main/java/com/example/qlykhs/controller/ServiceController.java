package com.example.qlykhs.controller;

import com.example.qlykhs.dto.respon.ServiceDto;
import com.example.qlykhs.dto.respon.ResponsiData;
import com.example.qlykhs.dto.respon.ServiceListDto;
import com.example.qlykhs.entity.Services;
import com.example.qlykhs.repositoty.ServiceReponsitory;
import com.example.qlykhs.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    private ServiceReponsitory serviceReponsitory;

    public ServiceController(ServiceReponsitory serviceReponsitory) {
        this.serviceReponsitory = serviceReponsitory;
    }

    @GetMapping("/all")
    public ResponseEntity<ResponsiData> allservice(){
        List<Services> serviceList = serviceService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsiData("ok","Get all Service",serviceList));
    }
    @PostMapping("/add")
    public ResponseEntity<ResponsiData> addservice(@RequestBody Services service){
        if(serviceService.check(service.getServiceId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsiData<>(HttpStatus.BAD_REQUEST.toString(),"Id: "+service.getServiceId()+ " đã có !",""));
        }else{

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponsiData(HttpStatus.CREATED.toString(),"Them thanh cong", serviceReponsitory.save(service)));
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponsiData> update(@PathVariable String id, @RequestBody ServiceDto service) {
        Optional<Services> check = serviceReponsitory.findById(id);
        if (check.isPresent()) {
            check.get().setServiceName(service.getServiceName());
            check.get().setPrice(service.getPrice());
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponsiData("200","Them thanh cong",serviceReponsitory.save(check.get())));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponsiData<>("failed","Không tồn tại dịch vụ với id : "+id,""));
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponsiData<ResponseEntity<?>> dale(@PathVariable String id) {
        ResponsiData responsiData =new ResponsiData();;
        if (serviceService.check(id)) {
            serviceService.delete(id);
            responsiData.setMessage("Thao tác xoá thành công!");
        }else {
            responsiData.setMessage("Không tồn tại dịch Vụ với id : "+id);
        }return responsiData;
    }
    @PutMapping("/search")
    public ResponsiData<ServiceListDto> searchLessThan(@RequestParam double price ){
        ResponsiData responsiData = new ResponsiData();
        List<Services> serviceList = serviceService.search(price);
        responsiData.setData(new ServiceListDto(serviceList));
        return responsiData;
    }

}
