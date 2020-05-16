package com.iagonyii.compagendaspring.services;

import com.iagonyii.compagendaspring.domain.User;
import com.iagonyii.compagendaspring.service.AuthService;
import com.iagonyii.compagendaspring.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthServiceTests {

    @Autowired
    private AuthService service;
    @Autowired
    private UserService userService;

    @BeforeAll
    public void deleteTestUser() {
        long id = userService.getIdForName("testUser");
        userService.deleteUser(id);
    }

    @Test
    @Order(1)
    public void a_RegisterNewUser() {
        User user = new User("testUser", "testUser@test.com", "secret");
        boolean success = service.register(user);

        assertTrue(success);
    }

    @Test
    @Order(2)
    public void b_RegisterAlreadyExists() {
        User user = new User("testUser", "test@test.com", "secrettest");
        boolean success = service.register(user);

        assertFalse(success);
    }


}
