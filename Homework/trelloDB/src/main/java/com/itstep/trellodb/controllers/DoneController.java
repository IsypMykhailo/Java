package com.itstep.trellodb.controllers;

import com.itstep.trellodb.entities.Doing;
import com.itstep.trellodb.entities.Done;
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
public class DoneController {
    private final ToDoRepository toDoRepository;
    private final DoingRepository doingRepository;
    private final DoneRepository doneRepository;
    private final UserRepository userRepository;

    public DoneController(
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

    @GetMapping("/done")
    private String index(Model model){
        model.addAttribute("dones", doneRepository.findAll());
        return "done";
    }

    @GetMapping("/done/create")
    public String create(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "/done-create";
    }

    @PostMapping("/done/store")
    public RedirectView store(
            @Param("user_id") long user_id,
            Done done
    ){
        done.setUser(userRepository.findById(user_id).get());
        doneRepository.save(done);
        return new RedirectView("/done");
    }

    @GetMapping("/done/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        Done c = doneRepository.findById(id).get();
        model.addAttribute("done", c);
        return "/done-update";
    }

    @GetMapping("/done/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ){
        doneRepository.deleteById(id);
        return new RedirectView("/done");
    }
}
