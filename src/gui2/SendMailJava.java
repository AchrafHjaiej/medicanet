/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.projet_sante.gui;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Youssef
 */
public class SendMailJava {
        private String username = "youssef.rezgui@esprit.tn";
    private String password = "213JMT7817";
    

public void sendMail(String to,String subject,String msg) {
Properties props = new Properties();
props.setProperty("mail.host", "smtp.gmail.com"); 
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");  
    props.put("mail.smtp.port", "465");  
    props.put("mail.debug", "true");  
    props.put("mail.smtp.socketFactory.port", "465");  
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
    props.put("mail.smtp.socketFactory.fallback", "false");
        Session session;
        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("youssef.rezgui@esprit.tn"));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(msg);
            Transport.send(message);
        System.out.println("Message_envoye");
        } catch (MessagingException e) {
        throw new RuntimeException(e);
        } }

        
        
    
    
    
    
}
