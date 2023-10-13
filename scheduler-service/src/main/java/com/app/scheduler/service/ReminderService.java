package com.app.scheduler.service;

import com.app.asset.model.Asset;
import com.app.maintenance.model.Maintenance;
import com.app.maintenance.repository.MaintenanceRepository;
import com.app.scheduler.repository.ReminderRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<Maintenance> getRemindersForToday() {
        Date today = new Date();

        return reminderRepository.findByMaintenanceDate(today);
    }

    public List<Maintenance> getMaintenanceByMaintenanceDateBetween(Date startDate, Date endDate) {
        return reminderRepository.findByMaintenanceDateBetween(startDate, endDate);
    }

    public List<Maintenance> getMaintenanceByAssetAndMaintenanceDate(Asset asset, Date maintenanceDate) {
        return reminderRepository.findByAssetAndMaintenanceDate(asset, maintenanceDate);
    }
}


