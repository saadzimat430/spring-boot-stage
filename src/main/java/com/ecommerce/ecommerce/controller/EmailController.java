package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.EmailInfo;
import com.ecommerce.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Properties;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Value("${app.emailPwd}")
    private String pwd;

    @Value("${app.emailAddress}")
    private String email;

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailInfo emailInfo) throws MessagingException {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(email);
        mailSender.setPassword(pwd);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        MimeMessagePreparator preparator = message -> {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, "UTF-8");
            helper.setFrom("Zenith Lighting <edmdemonz2000@gmail.com>");
            helper.setTo(emailInfo.getEmail());
            helper.setSubject("Order " + emailInfo.getOrderStatus());
            helper.setText(String.format("Hello %s, \nWe want to inform you that your order was %s.\n\nKind regards,\nZenith Lighting Inc.",
                    emailInfo.getFirstName(), emailInfo.getOrderStatus()));
        };

        mailSender.send(preparator);

        return ResponseEntity.ok("Email sent successfully!");
    }

}
