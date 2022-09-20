package com.itstep.activitar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about-us";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/blog-single")
    public String blog_single(){
        return "blog-single";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/gallery")
    public String gallery(){
        return "gallery";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/schedule")
    public String schedule(){
        return "schedule";
    }
}
