package com.itstep.firstspring.controllers;

import com.itstep.firstspring.entities.SiteContact;
import com.itstep.firstspring.repos.SiteContactRepository;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactFormController {

    private final SiteContactRepository contactRepository;

    public ContactFormController(SiteContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
    public String sendContact(
            SiteContact siteContact // На основе параметров запроса я могу сразу создать сущность
//            @RequestParam(value="name") String name,
//            @RequestParam(value="email") String email,
//            @RequestParam(value="phone") String phone,
//            @RequestParam(value="message")  @Nullable String message
    ){
//        if(siteContact.getName().length() < 10){
//            return " Name len < 10";
//        }
        contactRepository.save(siteContact); // Я сохраняю
        return "Ok";
//        return "Incoming: "
//                + name + " "
//                + email + " "
//                + phone + " "
//                + message;
    }
}
