package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.RoomType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoomTypeReponsitory extends JpaRepository<RoomType, String> {
}
