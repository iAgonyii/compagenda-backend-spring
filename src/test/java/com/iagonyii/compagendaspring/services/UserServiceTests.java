package com.iagonyii.compagendaspring.services;

import com.iagonyii.compagendaspring.domain.User;
import com.iagonyii.compagendaspring.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {

    @Autowired
    private UserService service;

    @BeforeAll
    public void cleanUsersDB() {
        User user = service.getUser(4);
        user.setEmail("to@bedone.com");
        service.editUser(user);
    }

    @Test
    @Order(1)
    public void a_getUsers() {
        boolean done;
        try {
            List<User> users = service.getUsers();
            done = true;
        }
        catch(Exception e) {
            done = false;
        }
        assertTrue(done);
    }

    @Test
    @Order(2)
    public void b_getUserById() {
        User user = service.getUser(4);

        assertEquals("iAgonyii", user.getUsername());
    }

    @Test
    @Order(3)
    public void c_editUserDetails() {
        String expectedEmail = "roy@roy.com";
        User user = service.getUser(4);
        user.setEmail("roy@roy.com");

        service.editUser(user);
        User edited = service.getUser(4);

        assertEquals(expectedEmail, edited.getEmail());
    }

    @Test
    @Order(4)
    public void d_getIdForName() {
        long expectedId = 4;
        long actual = service.getIdForName("iAgonyii");

        assertEquals(expectedId, actual);
    }

    @Test
    @Order(5)
    public void e_getIdforNameNotExist() {
        boolean nullreturned;

        try {
            service.getIdForName("soakdoksaokasdkodskos");
            nullreturned = true;
        }
        catch(Exception e) {
            nullreturned = false;
        }

        assertFalse(nullreturned);
    }
}
