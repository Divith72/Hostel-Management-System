package com.example.app.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "maintenance")
public class Maintenance {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long maintenance_id;
        private String description;
        @ManyToOne
         @JoinColumn(name = "user_id" , nullable = false)
        private User user_id;
        @ManyToOne  
         @JoinColumn(name = "room_id" , nullable = false)
        private Room room_id;
        private String status;
        public Long getMaintenance_id() {
            return maintenance_id;
        }
        public void setMaintenance_id(Long maintenance_id) {
            this.maintenance_id = maintenance_id;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public User getUser_id() {
            return user_id;
        }
        public void setUser_id(User user_id) {
            this.user_id = user_id;
        }
        public Room getRoom_id() {
            return room_id;
        }
        public void setRoom_id(Room room_id) {
            this.room_id = room_id;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }  


}
