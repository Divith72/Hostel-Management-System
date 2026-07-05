package com.example.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Model.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {
    

}
