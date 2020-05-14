package com.iagonyii.compagendaspring.service;


import com.iagonyii.compagendaspring.dao.AuthRepository;
import com.iagonyii.compagendaspring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthRepository repository;

//    public boolean login(String username, String password) {
//        Long id = userService.getIdForName(username);
//        EntityManager em = emf.createEntityManager();
//        dao = new AuthDao(em);
//
//        String hashpw = dao.getPassword(id);
//
//        if(hashpw == "") {
//            return false;
//        }
//        if (BCrypt.checkpw(password, hashpw)) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    public boolean register(User user) {
        if(repository.existsByName(user.getUsername()) == 1) {
            return false;
        }
        else {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            repository.save(user);
            return true;
        }
    }

//    private boolean CheckIfAlreadyExists(User user) {
//        EntityManager em = emf.createEntityManager();
//        dao = new AuthDao(em);
//        if(dao.CheckIfAlreadyExists(user)) {
//            return true;
//        }
//        else {
//            return false;
//        }
//
//    }
}
