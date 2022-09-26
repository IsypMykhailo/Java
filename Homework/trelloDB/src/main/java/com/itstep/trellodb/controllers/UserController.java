package com.itstep.trellodb.controllers;

import com.itstep.trellodb.entities.User;
import com.itstep.trellodb.repos.DoingRepository;
import com.itstep.trellodb.repos.DoneRepository;
import com.itstep.trellodb.repos.ToDoRepository;
import com.itstep.trellodb.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class UserController {
    private final ToDoRepository toDoRepository;
    private final DoingRepository doingRepository;
    private final DoneRepository doneRepository;
    private final UserRepository userRepository;

    public UserController(
            ToDoRepository toDoRepository,
            DoingRepository doingRepository,
            DoneRepository doneRepository,
            UserRepository userRepository
    ) {
        this.toDoRepository = toDoRepository;
        this.doingRepository = doingRepository;
        this.doneRepository = doneRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    private String index(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/user/create")
    public String create(Model model){
        return "/create";
    }

    @PostMapping("/user/store")
    public RedirectView store(
            User user
    ){
        userRepository.save(user);
        return new RedirectView("/user");
    }

    @GetMapping("/user/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") long id
    ){
        User c = userRepository.findById(id).get();
        model.addAttribute("user", c);
        return "/update";
    }

    @GetMapping("/user/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") long id
    ){
        userRepository.deleteById(id);
        return new RedirectView("/user");
    }
}
