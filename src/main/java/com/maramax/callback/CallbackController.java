package com.maramax.callback;

import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Recaptcha: <a href="https://github.com/mkopylec/recaptcha-spring-boot-starter">How to use</a>
 */
@Controller
public class CallbackController {
    @Autowired
    private CallbackService callbackService;

    @Autowired
    private RecaptchaValidator recaptchaValidator;

    @PostMapping("/callback")
    public String validateCaptcha(HttpServletRequest request, Callback callback) {
        ValidationResult result = recaptchaValidator.validate(request);
        if (result.isSuccess() && callback.getCheck() == 5) {
            callbackService.sendCallbackMessage(callback);

            return "redirect:/";
        } else {
            return "Callback form error: " + request.toString();
        }
    }
}
