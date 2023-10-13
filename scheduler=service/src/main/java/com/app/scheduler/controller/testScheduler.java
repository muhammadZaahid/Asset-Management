package com.app.scheduler.controller;

import com.app.scheduler.scheduler.MaintenanceReminderScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class testScheduler {

    @Autowired
    private MaintenanceReminderScheduler scheduler;

    @GetMapping("/trigger")
    public String triggerSchedulerManually() {
        scheduler.sendMaintenanceReminders();
        return "Scheduler triggered manually.";
    }
}
