package com.example.myfirstspringboot4.controllers;

import models.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


public interface Controller {
    public String index(Model model);


    public String show(int id, Model model);

    public String newPerson(Model model);

    public String save(User user, BindingResult bindingResult, Model model);

    public String edit(Model model, int id);

    public String update(User user,
                         BindingResult bindingResult, int id);

    public String delete(int id);
}
