package com.app.scheduler.scheduler;

import com.app.maintenance.model.Maintenance;
import com.app.scheduler.service.ReminderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MaintenanceReminderScheduler {
    private final ReminderService reminderService;

    public MaintenanceReminderScheduler(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    // Penjadwalan untuk mengingatkan tentang pemeliharaan pada pukul 9 pagi setiap hari jika sesuai
    @Scheduled(cron = "0 30 23 * * ?")
    public void sendMaintenanceReminders() {
        List<Maintenance> todayReminders = reminderService.getRemindersForToday();

        Date today = new Date();

        for (Maintenance reminder : todayReminders) {
            Date maintenanceDate = reminder.getMaintenanceDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (sdf.format(today).equals(sdf.format(maintenanceDate))) {
                // Mengambil alamat email penerima dari pengingat atau aset yang sesuai
                String recipientEmail = reminder.getTechnician().getEmail();

                String subject = "Pengingat Pemeliharaan";
                String messageText = "Hari ini adalah tanggal pemeliharaan untuk aset Anda.";

                // Mengirim email
                emailService.sendEmail(recipientEmail, subject, messageText);
            }
        }
    }
}

