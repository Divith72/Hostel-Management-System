package com.example.app.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private Long room_id;
        private String room_type;
        private Double price;
        private String status;


        public Long getRoom_no() {
            return room_id;
        }
        public void setRoom_no(Long room_id) {
            this.room_id = room_id;
        }
        public String getRoom_type() {
            return room_type;
        }
        public void setRoom_type(String room_type) {
            this.room_type = room_type;
        }
        public Double getPrice() {
            return price;
        }
        public void setPrice(Double price) {
            this.price = price;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        
}
