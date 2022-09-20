package com.itstep.firstspring.controllers;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactFormController {
    @PostMapping("/contact")
    public String sendContact(
            @RequestParam(value="name") String name,
            @RequestParam(value="email") String email,
            @RequestParam(value="phone") String phone,
            @RequestParam(value="message")  @Nullable String message
    ){
        return "Incoming: "
                + name + " "
                + email + " "
                + phone + " "
                + message;
    }
}
