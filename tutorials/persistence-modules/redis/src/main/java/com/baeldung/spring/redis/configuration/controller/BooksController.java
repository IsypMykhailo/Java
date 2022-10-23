package com.baeldung.spring.redis.configuration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.redis.configuration.entity.Book;
import com.baeldung.spring.redis.configuration.repository.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository repository;

    @PostMapping("/create")
    public String newBook(@RequestBody Book newBook) {
        repository.save(newBook);
        return "Added";
    }

    @GetMapping("/get/{id}")
    public Book findOne(@PathVariable Long id) {
        return repository.findById(id);
    }


    @GetMapping("/addTest")
    public Book addTest(){
        Book a1 = new Book("12");
        a1.setId(1L);
        Book a2 = new Book("Master");
        a2.setId(2L);
        repository.save(a1);
        repository.save(a2);
        return a1;
    }
}
