package com.itstep.activitar.controllers;

import com.itstep.activitar.entities.SiteContact;
import com.itstep.activitar.repos.SiteContactRepository;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContactFormController {
    private final SiteContactRepository contactRepository;

    public ContactFormController(SiteContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
    public String sendContact(
            SiteContact siteContact
//            @RequestParam(value="name") String name,
//            @RequestParam(value="email") String email,
//            @RequestParam(value="message")  @Nullable String message
    ){
//        return "Incoming: "
//                + name + " "
//                + email + " "
//                + message;
        contactRepository.save(siteContact);
        return "Ok";
    }

    @GetMapping("/contacts")
    public Iterable<SiteContact> readAll(){
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public Optional<SiteContact> readById(
            @PathVariable(name="id") Long id
    ){
        return contactRepository.findById(id);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteById(
            @PathVariable(name="id") Long id
    ){
        contactRepository.deleteById(id);
    }

    @PutMapping("/contacts/{id}")
    public void updateById(
            @PathVariable(name="id") Long id,
            SiteContact siteContact
    ) {
        contactRepository.save(siteContact);
    }
}
