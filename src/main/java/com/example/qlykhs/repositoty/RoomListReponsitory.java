package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.RoomList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoomListReponsitory extends JpaRepository<RoomList, Long> {
    void deleteByRentalSlipId(String id);
}
