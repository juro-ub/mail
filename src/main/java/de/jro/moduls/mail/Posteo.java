package de.jro.moduls.mail;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Posteo extends Mail {

    private static final int MAX_TRY = 5;

    public Posteo() {

    }

    @Override
    protected void sendMail(String header, String content, String filePath,
            String fromMail, String toMail, String authFromName, String authFromPw) throws Exception {

        File file = new File(filePath);

        //Posteo Props
        Properties props = new Properties();

        props.put("mail.smtp.host", "posteo.de");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                try {
                    return new PasswordAuthentication(authFromName, authFromPw);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromMail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
        message.setSubject(header);
        // creates message part
        Multipart multipart = new MimeMultipart();
        // set Content
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html");
        multipart.addBodyPart(messageBodyPart);
        // add File
        if (file != null && file.exists()) {
            MimeBodyPart attachPart = new MimeBodyPart();
            attachPart.attachFile(file);
            multipart.addBodyPart(attachPart);

        }
        // sets the multi-part as e-mail's content
        message.setContent(multipart);
        for (int i = 0; i < MAX_TRY; i++) {
            try {
                Transport.send(message);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                if (i == (MAX_TRY - 1)) {
                    throw new Exception(e);
                }
            }
        }

    }
}
