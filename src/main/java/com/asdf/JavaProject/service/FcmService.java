package com.asdf.JavaProject.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FcmService {
    private FirebaseMessaging instace;

    public void sendTargetMessage(String targetToken, String title, String body) throws FirebaseMessagingException{
        this.sendTargetMessage(targetToken, title, body, null);
    }

    public void sendTargetMessage(String targetToken, String title, String body, String image) throws FirebaseMessagingException{
        Notification notification = Notification.builder().setTitle(title).setBody(body).setImage(image).build();
        Message msg = Message.builder().setToken(targetToken).setNotification(notification).build();
        sendMessage(msg);
    }

    public String sendMessage(Message message)throws FirebaseMessagingException{
        return this.instace.send(message);
    }
}
