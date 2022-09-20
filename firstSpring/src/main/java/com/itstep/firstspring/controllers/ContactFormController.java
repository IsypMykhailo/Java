package com.itstep.firstspring.controllers;

import com.itstep.firstspring.entities.SiteContact;
import com.itstep.firstspring.repos.SiteContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContactFormController {

    private final SiteContactRepository contactRepository;

    public ContactFormController(SiteContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * Создание записи в базе данных -- Create
     * @param siteContact
     * @return
     */
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

    /**
     * Чтение всех записей -- Read
     * @return
     */
    @GetMapping("/contacts")
    public Iterable<SiteContact> readAll(){
        return contactRepository.findAll();
    }

    /**
     * Чтение записей по id -- Read
     * @return
     */
    @GetMapping("/contacts/{id}")
    public Optional<SiteContact> readById(
            @PathVariable(name="id") Long id
    ){
        return contactRepository.findById(id);
    }

    /**
     * Удаление записи по Id -- Delete
     * @param id
     */
    @DeleteMapping("/contacts/{id}")
    public void deleteById(
            @PathVariable(name="id") Long id
    ){
        contactRepository.deleteById(id);
    }

    /**
     * Обновление записи в базе данных по её Id -- Update
     * @param id
     * @param siteContact
     */
    @PutMapping("/contacts/{id}")
    public void updateById(
            @PathVariable(name="id") Long id,
            SiteContact siteContact
    ) {
        contactRepository.save(siteContact);
    }
}
