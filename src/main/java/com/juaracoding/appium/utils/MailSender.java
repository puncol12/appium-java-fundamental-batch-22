package com.juaracoding.appium.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailSender {
final static String username = "2ccb4de6a8ca14";
final static String password = "48ae0c3d03ca79";

public static void send() {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    try {
        String isiHTMLString = new String(Files.readAllBytes(Paths.get("target/surefire-reports/emailable-report.html")));
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("noreply@kelabang.tikam"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dev@mail.com"));
        message.setSubject("INI BARU PERCOBAAN EMAIL TESTING");

        message.setContent(isiHTMLString, "text/html; charset=utf-8");

        Transport.send(message);

        System.out.println("EMAIL BERHASIL DIKIRIM");
    } catch (Exception e) {
        System.out.println("EMAIL GAGAL DIKIRIM" + e.getMessage());
    }
}
}
