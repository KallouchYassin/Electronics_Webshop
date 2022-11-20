package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
@PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }
    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user)
    {
        return userService.registerUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin()
    {
        return"only for admin";
    }

    @GetMapping("/forUser")
    public String forUser()
    {
        return"only for user";
    }

}
