package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerReponsitory extends JpaRepository<Customer,String> {
    List<Customer> findByUserContaining(String user);
    boolean existsByUser(String user);
    Optional<Customer> findByUser(String user);
}
