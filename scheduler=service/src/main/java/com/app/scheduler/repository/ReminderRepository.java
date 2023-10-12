package com.app.scheduler.repository;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Maintenance, String> {
    List<Maintenance> findByMaintenanceDate(Date maintenanceDate);

    List<Maintenance> findByMaintenanceDateBetween(Date startDate, Date endDate);

    List<Maintenance> findByAssetAndMaintenanceDate(Asset asset, Date maintenanceDate);

}


