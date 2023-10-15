package com.app.maintenance.repository;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import com.app.technician.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {

    @Query(value = "SELECT * FROM maintenance_records mr " +
            " WHERE asset_id = ?1", nativeQuery = true)
    List<Maintenance> findByAssetId(String assetId);
    @Query(value = " SELECT * FROM maintenance_records mr " +
            " WHERE mr.id = ?1", nativeQuery = true)
    Maintenance findMaintenanceById(String id);
    @Query(value = " SELECT * FROM maintenance_records mr " +
            " WHERE technician_id = ?1", nativeQuery = true)
    List<Maintenance> findByTechnicianId(String technicianId);
    @Query(value = "SELECT * FROM maintenance_records WHERE maintenance_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Maintenance> findMaintenanceByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    List<Maintenance> findByAssetAndMaintenanceDateBetween(Asset asset, Date startDate, Date endDate);
    List<Maintenance> findByAssetAndCostBetween(Asset asset, Double minCost, Double maxCost);

}

