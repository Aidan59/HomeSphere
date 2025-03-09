package com.example.HomeSphere.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendConfirmationEmail(String to) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dan0740plotnikov@yandex.ru");
        message.setTo(to);
        System.out.println(to);
        message.setSubject("subject");
        message.setText("test");
        mailSender.send(message);
    }
}
