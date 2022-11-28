package com.maramax.callback;

import com.maramax.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallbackService {
    @Autowired
    private MailSenderService mailSenderService;

    public void sendCallbackMessage(Callback callback) {
        String message = String.format(
            "Name: %s\n" +
            "Email: %s\n" +
            "Tel: %s\n" +
            "Count: %s\n" +
            "Message: %s\n",
                callback.getName(),
                callback.getEmail(),
                callback.getTel(),
                callback.getQuantity(),
                callback.getMessage()
        );

        mailSenderService.sendEmail("office@maramax.kiev.ua", "Callback form Maramax", message);
    }
}
