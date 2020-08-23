/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Giannela HC
 */
public class EnvioSmtp {
    
    private final String servidorSmtp;
    private IMediator mediator;
    
    private Session session;
    private String user,pass;
    
    public EnvioSmtp(final String servidorSmtp, IMediator mediator) {
        this.servidorSmtp = servidorSmtp;
        this.mediator = mediator;
    }
    
    private void config(){
        user = "giannelahc@gmail.com";//correo gmail sender
        pass = "";//contra
        Properties properties =new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        
        session = Session.getInstance(properties, new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(user,pass);
        }
        });  
    }
    
    public void preparaMensaje(String asunto,String cuerpo,String correo)  {
        
        //config();
        mediator.success(asunto);
//        MimeMessage mail = new MimeMessage(session);
//        try {
//            mail.setFrom(new InternetAddress(user));
//            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
//            mail.setSubject(asunto);
//            mail.setText(cuerpo);
//            
//            try (Transport transport = session.getTransport(this.servidorSmtp)) {
//                transport.connect(user, pass);
//                transport.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
//                
//            }
//            
//        } catch (AddressException ex) {
//            Logger.getLogger(EnvioSmtp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MessagingException ex) {
//            Logger.getLogger(EnvioSmtp.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
