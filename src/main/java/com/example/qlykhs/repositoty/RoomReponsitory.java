package com.example.qlykhs.repositoty;

import com.example.qlykhs.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReponsitory extends JpaRepository<Room, String> {
}
