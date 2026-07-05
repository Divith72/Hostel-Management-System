package com.example.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Model.Maintenance;

public interface MaintenanceRepo extends JpaRepository<Maintenance, Long> {

}
