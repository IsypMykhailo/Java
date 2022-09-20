package com.itstep.firstspring.controllers;

import com.itstep.firstspring.repos.SiteContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CFController {
    private final SiteContactRepository contactRepository;

    public CFController(SiteContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @GetMapping("/cf")
    public String getAll(Model model){
        model.addAttribute("all", contactRepository.findAll());
        return "cf/all";
    }
}
