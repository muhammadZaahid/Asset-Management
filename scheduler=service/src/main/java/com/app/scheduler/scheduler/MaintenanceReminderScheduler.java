package com.app.scheduler.scheduler;

import com.app.email.service.EmailService;
import com.app.maintenance.model.Maintenance;
import com.app.scheduler.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MaintenanceReminderScheduler {

    private final ReminderService reminderService;
    private final EmailService emailService;

    @Autowired
    public MaintenanceReminderScheduler(ReminderService reminderService, EmailService emailService) {
        this.reminderService = reminderService;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 50 23 * * ?")
    public void sendMaintenanceReminders() {
        List<Maintenance> todayReminders = reminderService.getRemindersForToday();

        Date today = new Date();

        for (Maintenance reminder : todayReminders) {
            Date maintenanceDate = reminder.getMaintenanceDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (sdf.format(today).equals(sdf.format(maintenanceDate))) {
                String recipientEmail = reminder.getTechnician().getEmail();

                String subject = "Pengingat Pemeliharaan";
                String messageText = "Hari ini adalah tanggal pemeliharaan untuk aset Anda.";

                emailService.sendEmail(recipientEmail, subject, messageText);
            }
        }
    }
}

