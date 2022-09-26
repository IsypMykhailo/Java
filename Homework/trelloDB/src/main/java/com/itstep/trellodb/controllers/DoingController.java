package com.itstep.trellodb.controllers;

import com.itstep.trellodb.entities.Doing;
import com.itstep.trellodb.entities.ToDo;
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
public class DoingController {
    private final ToDoRepository toDoRepository;
    private final DoingRepository doingRepository;
    private final DoneRepository doneRepository;
    private final UserRepository userRepository;

    public DoingController(
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

    @GetMapping("/doing")
    private String index(Model model){
        model.addAttribute("doings", doingRepository.findAll());
        return "doing";
    }

    @GetMapping("/doing/create")
    public String create(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "/doing-create";
    }

    @PostMapping("/doing/store")
    public RedirectView store(
            @Param("user_id") long user_id,
            Doing doing
    ){
        doing.setUser(userRepository.findById(user_id).get());
        doingRepository.save(doing);
        return new RedirectView("/doing");
    }

    @GetMapping("/doing/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        Doing c = doingRepository.findById(id).get();
        model.addAttribute("doing", c);
        return "/doing-update";
    }

    @GetMapping("/doing/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ){
        doingRepository.deleteById(id);
        return new RedirectView("/doing");
    }
}
