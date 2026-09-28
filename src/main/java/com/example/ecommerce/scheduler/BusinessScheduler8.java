package com.example.ecommerce.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BusinessScheduler8 {
    @Scheduled(cron = "0 0 * * * *")
    public void execute() {
        // Scheduled business placeholder for module 8.
    }
}
