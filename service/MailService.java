package com.example.asm2java202.service;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    public void send(String to, String subject, String content){
        System.out.println("Send mail to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Content: " + content);
    }
}
