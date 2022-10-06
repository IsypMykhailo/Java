package com.itstep.firstspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "pages/index";
    }
    @GetMapping("/about")
    public String about(){
        return "pages/about";
    }
    @GetMapping("/post")
    public String post(){
        return "pages/post";
    }
    @GetMapping("/contact")
    public String contact(){
        return "pages/contact";
    }
}
