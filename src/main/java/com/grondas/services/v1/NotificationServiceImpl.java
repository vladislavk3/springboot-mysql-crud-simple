package com.grondas.services.v1;

import com.sendgrid.*;
import lombok.SneakyThrows;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;

    
    @Override
    @SneakyThrows
    public void notify(String emailAddress, String message) {
    	try {
    	Email from = new Email("no-reply@transfers.com");
        Email to = new Email(emailAddress);
        Content content = new Content("text/html", message);
        Mail mail = new Mail(from, "Transfer Notification", to, content);

        SendGrid sendGrid = new SendGrid(sendGridApiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        
    }
}
