package com.app.maintenance.repository;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {
    List<Maintenance> findByAsset(Asset asset);
    List<Maintenance> findByTechnician(String technician);
    List<Maintenance> findByMaintenanceDateBetween(Date startDate, Date endDate);
    List<Maintenance> findByAssetAndMaintenanceDateBetween(Asset asset, Date startDate, Date endDate);
    List<Maintenance> findByAssetAndCostBetween(Asset asset, Double minCost, Double maxCost);
    List<Maintenance> findByDescriptionContaining(String keyword);
}

