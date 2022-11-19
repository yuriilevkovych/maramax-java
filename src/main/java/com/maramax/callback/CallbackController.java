package com.maramax.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CallbackController {
    @Autowired
    private CallbackService callbackService;

    @PostMapping("/callback")
    public String callback(Callback callback) {
        callbackService.sendCallbackMessage(callback);

        return "redirect:/";
    }

}
