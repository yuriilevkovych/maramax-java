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

        mailSenderService.sendEmail("yu.destroyer.ok@gmail.com", "Заявка на зворотній звязок", message);
//        mailSenderService.sendEmail("office@maramax.kiev.ua", "Callback form Maramax", message);
        mailSenderService.sendEmail("m.kysilov@maramax.kiev.ua", "Заявка на зворотній звязок", message);
        mailSenderService.sendEmail("a.martynenko@maramax.kiev.ua", "Заявка на зворотній звязок", message);
    }
}
