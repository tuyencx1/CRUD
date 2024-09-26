package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.ServiceList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ServiceListReponsitory extends JpaRepository<ServiceList,String> {
    void deleteByRentalSlipId(String id);
}
