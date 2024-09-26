package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Invoice;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InvoiceSeponsitory extends JpaRepository<Invoice, String> {
    void deleteByRentalSlipId(String id);
}
