package com.mykhailo.timezone.controllers;

import com.mykhailo.timezone.entities.Cart;
import com.mykhailo.timezone.entities.User;
import com.mykhailo.timezone.repos.CartRepository;
import com.mykhailo.timezone.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;
    private final CartRepository cartRepository;

    public RegistrationController(UserService userService, CartRepository cartRepository) {
        this.userService = userService;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@Param("username") String username ,
                          @Param("password") String password,
                          @Param("email") String email,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("passwordConfirm") String passwordConfirm,
                          @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "pages/registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "pages/registration";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordConfirm);


        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "pages/registration";
        }
        Cart c = new Cart();
        c.setUser(user);
        cartRepository.save(c);
        user.setCart(cartRepository.findById(c.getId()).get());
        userService.saveUser(user);
        return "redirect:/";
    }
}
