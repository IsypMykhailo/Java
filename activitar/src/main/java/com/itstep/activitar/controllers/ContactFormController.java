package com.itstep.activitar.controllers;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactFormController {
    @PostMapping("/contact")
    public String sendContact(
            @RequestParam(value="name") String name,
            @RequestParam(value="email") String email,
            @RequestParam(value="message")  @Nullable String message
    ){
        return "Incoming: "
                + name + " "
                + email + " "
                + message;
    }
}
