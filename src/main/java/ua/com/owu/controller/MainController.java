package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    @GetMapping()
    public String users() {

        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@RequestParam("name") String name, @RequestParam String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        userService.save(user);
        return "index";
    }
}