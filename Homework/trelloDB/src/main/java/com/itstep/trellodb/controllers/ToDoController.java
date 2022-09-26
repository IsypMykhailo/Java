package com.itstep.trellodb.controllers;

import com.itstep.trellodb.entities.ToDo;
import com.itstep.trellodb.entities.User;
import com.itstep.trellodb.repos.DoingRepository;
import com.itstep.trellodb.repos.DoneRepository;
import com.itstep.trellodb.repos.ToDoRepository;
import com.itstep.trellodb.repos.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class ToDoController {
    private final ToDoRepository toDoRepository;
    private final DoingRepository doingRepository;
    private final DoneRepository doneRepository;
    private final UserRepository userRepository;

    public ToDoController(
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

    @GetMapping("/todo")
    private String index(Model model){
        model.addAttribute("todos", toDoRepository.findAll());
        return "toDo";
    }

    @GetMapping("/todo/create")
    public String create(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "/toDo-create";
    }

    @PostMapping("/todo/store")
    public RedirectView store(
            @Param("user_id") long user_id,
            ToDo toDo
    ){
        toDo.setUser(userRepository.findById(user_id).get());
        toDoRepository.save(toDo);
        return new RedirectView("/todo");
    }

    @GetMapping("/todo/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        ToDo c = toDoRepository.findById(id).get();
        model.addAttribute("todo", c);
        return "/toDo-update";
    }

    @GetMapping("/todo/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ){
        toDoRepository.deleteById(id);
        return new RedirectView("/todo");
    }
}
