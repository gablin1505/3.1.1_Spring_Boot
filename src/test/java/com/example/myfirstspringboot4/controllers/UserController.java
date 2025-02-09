package com.example.myfirstspringboot4.controllers;

import jakarta.validation.Valid;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.UserService;


@Controller
@RequestMapping("/users")
public class UserController implements controllers.Controller {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }


    @GetMapping("/show")
    @Override
    public String show(@RequestParam("id") int id, Model model) {
        for (User user : userService.index()) {
            if (user.getId() == id) {
                model.addAttribute("user", user);
            }
        }
        return "show";
    }


    @GetMapping("/new")
    @Override
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "new";

    }


    @PostMapping("/new")
    @Override
    public String save(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "new";
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    @Override
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping("/update")
    @Override
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }


    @PostMapping("/delete")
    @Override
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @RequestMapping("/")
    public String home() {
        return "redirect:/users";
    }
}


