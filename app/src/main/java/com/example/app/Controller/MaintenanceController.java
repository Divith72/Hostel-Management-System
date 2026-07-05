package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.app.Model.Maintenance;
import com.example.app.Service.MaintenanceService;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
          
    @Autowired
    private MaintenanceService maintenanceservice;

    @GetMapping("/all")
    public ResponseEntity<List<Maintenance>> getAllMaintenanceTasks() {
        List<Maintenance> tasks = maintenanceservice.getAllMaintenanceTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{maintenance_id}")
    public ResponseEntity<Maintenance> getMaintenanceTask(@PathVariable Long maintenance_id) {
        Maintenance task = maintenanceservice.getMaintenanceTask(maintenance_id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/add")
    public ResponseEntity<Maintenance> addMaintenanceTask(@RequestBody Maintenance maintenance) {
        Maintenance newTask = maintenanceservice.createMaintenanceTask(maintenance);
        return ResponseEntity.ok(newTask);
    }       

    @PutMapping("/perform/{maintenance_id}")
    public ResponseEntity<String> performMaintenanceTask(@PathVariable Long maintenance_id) {
        String result = maintenanceservice.performMaintenanceTask(maintenance_id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{maintenance_id}")
    public ResponseEntity<Maintenance> updateMaintenanceTask(
            @PathVariable Long maintenance_id,
            @RequestBody Maintenance maintenance) {
        Maintenance updatedTask = maintenanceservice.updateMaintenanceTask(maintenance_id, maintenance);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/delete/{maintenance_id}")
    public ResponseEntity<Void> deleteMaintenanceTask(@PathVariable Long maintenance_id) {
        maintenanceservice.deleteMaintenanceTask(maintenance_id);
        return ResponseEntity.ok().build();
    }   
}
