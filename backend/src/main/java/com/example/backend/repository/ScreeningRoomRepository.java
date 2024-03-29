package com.example.backend.repository;

import com.example.backend.model.ScreeningRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ScreeningRoomRepository extends JpaRepository<ScreeningRoom, Long> {

}
