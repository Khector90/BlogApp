package com.codeup.blogapp.service;

import com.codeup.blogapp.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;
    private String subject;

    public void preparedAndSend(Post post, String title, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(post.getUser().getEmail());
        message.setSubject(subject);
        message.setText(body);


        try{
            this.emailSender.send(message);
        } catch(MailException ex){
            System.out.println(ex.getMessage());
        }
    }

}
