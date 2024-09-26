package com.example.qlykhs.repositoty;

import com.example.qlykhs.dto.RentailSlipDto;
import com.example.qlykhs.dto.respon.RentalSlipListDto;
import com.example.qlykhs.entity.RentalSlip;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface RentalSlipReponsitory extends JpaRepository<RentalSlip,String> {
     @Query("select new com.example.qlykhs.dto.RentailSlipDto(r.rentalSlipId,r.startDate,r.endDate,r.roomNumber,r.customerNumber,r.deposit,s.staffId,s.staffName,c.customerId,c.customerName,i.invoiceId,i.creatDate)  " +
             "from RentalSlip r  inner join Staff s ON s.staffId = r.staffId inner join Customer c on r.customerId = c.customerId inner join Invoice i on r.rentalSlipId = i.rentalSlipId where r.rentalSlipId =:rentalSlipId")
     List<RentailSlipDto> findRentalSlipDto(@Param("rentalSlipId") String rentalSlipId);
}
