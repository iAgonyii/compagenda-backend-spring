package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.User;
import com.iagonyii.compagendaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService service;

    @GetMapping("/{uid}")
    public User getUser(@PathVariable("uid") long uid) {
        return service.getUser(uid);
    }

    @PostMapping("/{uid}")
    public User editUser(@PathVariable("uid") long uid, User user) {
        user.setId(uid);
        return service.editUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/getId/{username}")
    public Long getUsers(@PathVariable("username") String username) {
        return service.getIdForName(username);
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addUser(User user) {
//        service.addUser(user);
//    }
}
