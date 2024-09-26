package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Services;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ServiceReponsitory extends JpaRepository<Services,String> {
    @Query("select p from Services p where p.price < :maxPrice")
    List<Services> findpricelessthanX(@Param("maxPrice") double maxPrice);
}
