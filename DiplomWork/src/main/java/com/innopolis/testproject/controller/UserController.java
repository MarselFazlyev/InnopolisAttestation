package com.innopolis.testproject.controller;

import com.innopolis.testproject.domain.User;
import com.innopolis.testproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/registration")
    public String getRegisterPage(Map<String, Object> model) {
        return "registerpage";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Map<String, Object> model) {
        return "loginpage";
    }

    @PostMapping(value = "/registration")
    public String setUser(User user, Map<String, Object> model){
        UserDetails userFromDb = userService.loadUserByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Username уже зарегестрирован!");
            return "redirect:/registration";
        }

        userService.addUser(user);
        return "redirect:/";
    }
}
