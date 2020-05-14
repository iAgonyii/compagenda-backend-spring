package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.User;
import com.iagonyii.compagendaspring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRest {

    @Autowired
    private AuthService service;

    @PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public void register(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User(username, email, password);
//        if(service.register(user)) {
//            return Response.status(201).build();
//        }
//        else {
//            return Response.status(409).build();
//        }
        service.register(user);
    }
}
