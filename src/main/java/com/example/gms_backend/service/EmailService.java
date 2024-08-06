package com.example.gms_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationCode(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Verification Code");
        message.setText("You have requested to reset your password. Your verification code is: " + code + "\n\n" +
                "This code is valid for 1 minute. If you did not request a password reset, please ignore this email.\n\n" +
                "Thank you");

        javaMailSender.send(message);
    }

    public void sendMembershipRegistration(String email, String customerName, String membershipType, Date startDate, Date endDate, Double amountPaid) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome! Your Membership Registration is Successful");
        String text = "Dear " + customerName + ",\n\n" +
                "Thank you for choosing us as your fitness partner. We are pleased to inform you that your membership registration has been successfully completed. Below are the details of your membership:\n\n" +
                "Membership package: " + membershipType + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Amount Paid: " + amountPaid + " $" + "\n\n" +
                "As a valued member, you now have access to our state-of-the-art facilities, a wide range of workout classes, and personalized training sessions with our experienced coaches.\n\n" +
                "To make the most out of your membership, we encourage you to:\n" +
                "- Download our mobile app to easily manage your bookings and track your progress.\n" +
                "- Attend our orientation session to familiarize yourself with our facilities and services.\n" +
                "- Take advantage of our special member-only offers and events.\n\n" +
                "If you have any questions or need assistance, please do not hesitate to contact us or visit our front desk.\n\n" +
                "Thank you once again for choosing us. We look forward to supporting you on your fitness journey.\n\n" +
                "Best regards!";
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendReminderExpiringSoon(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reminder: Your Membership is Expiring Soon");
        message.setText("Renew Now to Continue Your Fitness Journey!");

        javaMailSender.send(message);
    }
}
