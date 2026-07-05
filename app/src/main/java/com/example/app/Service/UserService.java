package com.example.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Model.User;
import com.example.app.Repo.UserRepo;

@Service
public class UserService {

        @Autowired
        private UserRepo userRepo;

        public List<User> getAllUsers() {
            return userRepo.findAll();
        }

        public User addUser(User newUser){
            return userRepo.save(newUser);
        }

        public User editUser(Long User_id, User updatedUser){
            User existingUser = userRepo.findById(User_id).orElse(null);
            if(existingUser != null){
                existingUser.setName(updatedUser.getName());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setContact_no(updatedUser.getContact_no());
                return userRepo.save(existingUser);
            }else{
                updatedUser.setUser_id(User_id);
                return userRepo.save(updatedUser);  
            }
    
        }

        public String deleteUser(Long User_id){
            User foundUser = userRepo.findById(User_id).orElse(null);
            if(foundUser != null){
                userRepo.deleteById(User_id);
                return "User with id "+User_id+" deleted successfully.";   
            }else{
                return "User with id "+User_id+" not found.";
            }
            
        }
}
