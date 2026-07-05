package com.example.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Model.Maintenance;
import com.example.app.Repo.MaintenanceRepo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepo maintenancerepo;    

    public List<Maintenance> getAllMaintenanceTasks() {
        return maintenancerepo.findAll();
    }

    public Maintenance getMaintenanceTask(Long maintenance_id) {
        return maintenancerepo.findById(maintenance_id)
            .orElseThrow(() -> new EntityNotFoundException("Maintenance task not found with id: " + maintenance_id));
    }

    public Maintenance createMaintenanceTask(Maintenance maintenance) {
        return maintenancerepo.save(maintenance);
    }

    public String performMaintenanceTask(Long maintenance_id) {
        Optional<Maintenance> maintenanceOpt = maintenancerepo.findById(maintenance_id);
        if (!maintenanceOpt.isPresent()) {
            throw new EntityNotFoundException("Maintenance task not found with id: " + maintenance_id);
        }
        
        Maintenance maintenance = maintenanceOpt.get();
        maintenance.setStatus("COMPLETED");
        maintenancerepo.save(maintenance);
        return "Maintenance task with id " + maintenance_id + " performed successfully.";
    }

    public Maintenance updateMaintenanceTask(Long maintenance_id, Maintenance updatedMaintenance) {
        if (!maintenancerepo.existsById(maintenance_id)) {
            throw new EntityNotFoundException("Maintenance task not found with id: " + maintenance_id);
        }
        updatedMaintenance.setMaintenance_id(maintenance_id);
        return maintenancerepo.save(updatedMaintenance);
    }

    public void deleteMaintenanceTask(Long maintenance_id) {
        if (!maintenancerepo.existsById(maintenance_id)) {
            throw new EntityNotFoundException("Maintenance task not found with id: " + maintenance_id);
        }
        maintenancerepo.deleteById(maintenance_id);
    }
}
