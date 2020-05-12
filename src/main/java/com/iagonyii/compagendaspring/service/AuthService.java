//package com.iagonyii.compagendaspring.service;
//
//import dao.AuthDao;
//import dao.IAuthDao;
//import domain.User;
//import org.mindrot.jbcrypt.BCrypt;
//
//import javax.ejb.Stateless;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//@Stateless
//public class AuthService {
//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");
//    private IAuthDao dao;
//
//    @Inject
//    private UserService userService;
//
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
//
//    public boolean register(User user) {
//        if(CheckIfAlreadyExists(user)) {
//            return false;
//        }
//        else {
//            EntityManager em = emf.createEntityManager();
//            dao = new AuthDao(em);
//            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//            dao.register(user);
//            return true;
//        }
//    }
//
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
//}
