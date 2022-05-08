package com.example.test.controllers;

import com.example.test.models.Notification;
import com.example.test.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "http://localhost:4200/")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/save")
    public Notification saveNotification(@RequestBody Notification notification){
        return notificationService.saveNotification(notification);
    }
}
