package com.iagonyii.compagendaspring.service;

import com.iagonyii.compagendaspring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iagonyii.compagendaspring.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(long uid) {
        return repository.findById(uid).get();
    }

    public User editUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(long id) { repository.deleteById(id); }

    public long getIdForName(String username) {
        return repository.getIdForName(username);
    }


}
