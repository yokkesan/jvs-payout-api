package com.jvspayout.api;

import org.springframework.web.bind.annotation.*;
import com.jvspayout.api.service.EmailVerificationService;

@RestController
@RequestMapping("/api/auth")
public class EmailVerificationController {

    private final EmailVerificationService service;

    public EmailVerificationController(EmailVerificationService service) {
        this.service = service;
    }

    @PostMapping("/send-code")
    public void sendCode(@RequestParam String email) {
        service.sendVerificationCode(email);
    }

    @PostMapping("/verify-code")
    public boolean verifyCode(
            @RequestParam String email,
            @RequestParam String code) {

        return service.verifyCode(email, code);
    }

}