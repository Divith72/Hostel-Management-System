package com.example.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Model.Room;
import com.example.app.Repo.RoomRepo;

@Service
public class RoomService {
        
    @Autowired
    private RoomRepo roomrepo;

    public List<Room> getRooms(){
        return roomrepo.findAll();
    }

    public Room addRoom(Room newRoom){
        return roomrepo.save(newRoom);
    }

    public Room editRoom(Long room_id,Room updateRoom){
            Room oldRoom = roomrepo.findById(room_id).orElse(updateRoom);
            if(oldRoom !=  null){
                Room room=oldRoom;
                room.setRoom_type(updateRoom.getRoom_type());
                room.setPrice(updateRoom.getPrice());
                room.setStatus(updateRoom.getStatus());
                return roomrepo.save(room);
            }else{
                updateRoom.setRoom_no(room_id);
                return roomrepo.save(updateRoom);
            }
    }

    public String deleteRoom(Long room_id){
        Room foundRoom = roomrepo.findById(room_id).orElse(null);
        if(foundRoom != null){
            roomrepo.deleteById(room_id);
            return "Room with id "+room_id+" deleted successfully.";   
        }else{
            return "Room with id "+room_id+" not found.";
        }
        
    }
    
}
