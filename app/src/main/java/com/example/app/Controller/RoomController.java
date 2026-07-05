package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.app.Model.Room;
import com.example.app.Service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

        @Autowired
        private RoomService roomservice;

        @GetMapping("/all")
        public List<Room> getAllRooms(){
            return roomservice.getRooms();
        }

        @PostMapping("/add")
        public Room addRoom(@RequestBody Room newRoom){
            return roomservice.addRoom(newRoom);
        }   

        @PutMapping("/edit/{room_id}")
        public Room editRoom(@PathVariable Long room_id, @RequestBody Room updateRoom){
            return roomservice.editRoom(room_id, updateRoom);
        }   

        @RequestMapping("/delete/{room_id}")
        public String deleteRoom(@PathVariable Long room_id){
            return roomservice.deleteRoom(room_id);
        }   

}
