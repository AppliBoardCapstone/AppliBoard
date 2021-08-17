//package com.appliboard.appliboard.services;
//
//import com.appliboard.appliboard.models.JobApplication;
//import com.appliboard.appliboard.models.Reminder;
//import com.appliboard.appliboard.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Service("mailService")
//public class EmailService {
//
//    @Autowired
//    public JavaMailSender emailSender;
//
//    @Value("applitraq@gmail.com") // email that is always sending (ex: no reply emails)
//    private String from;
//
//    public void prepareAndSend(User user, String reminderSelect, JobApplication jobApp, Reminder reminder) { // job application added
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
//        msg.setTo(user.getEmail()); // changes from 'to' to post so the post can be sent instead
//
//        // switch case goes here // email // app portal // research
//        switch(reminderSelect) {
//            case "email":
//                String subject = "Remember to follow up with" + jobApp.getCompany();
//                msg.setSubject(subject);
//
//                String body = jobApp.getTitle() + reminder.getTitle() + reminder.getDescription();
//                msg.setText(body);
//                break;
//
//            case "appPortal":
//                subject = "Remember to check the application portal for " + reminder.getJobApplication().getTitle(); // check status on app, etc.
//                msg.setSubject(subject);
//
//                body = "INFO OF APP" + reminder.getJobApplication().getDescription();
//                msg.setText(body);
//                break;
//
//            case "research":
//                subject = "Remember to research on the following company: " + reminder.getJobApplication().getCompany();
//                msg.setSubject(subject);
//
//                body = "RESEARCH INFO" + reminder.getJobApplication().getDescription();
//                msg.setText(body);
//                break;
//
//        }
//
//
//
//        try{
//            this.emailSender.send(msg);
//        }
//        catch (MailException ex) {
//            // simply log it and go on...
//            System.err.println(ex.getMessage());
//        }
//    }
//
//}
