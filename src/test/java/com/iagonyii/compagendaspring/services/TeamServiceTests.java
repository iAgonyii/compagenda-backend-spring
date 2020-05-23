package com.iagonyii.compagendaspring.services;

import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.service.TeamService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamServiceTests {

    @Autowired
    private TeamService service;

    @Test
    @Order(1)
    public void a_CreateTeam() {
        boolean created = service.createTeam("TSM", 4);
        assertTrue(created);
    }

    @Test
    @Order(2)
    public void b_CreateTeamAlreadyExists() {
        boolean exists;

        try {
            boolean created = service.createTeam("TSM", 5);
            exists = false;
        }
        catch(EntityExistsException e) {
            exists = true;
        }

        assertTrue(exists);
    }

    @Test
    @Order(3)
    public void c_DeleteTeam() {
        List<Team> list = service.getTeams();
        Team team = list.get(list.size() - 1);

        boolean deleted;
        try {
            service.deleteTeam(team.getId());
            deleted = true;
        }
        catch(Exception e) {
            deleted = false;
        }

        assertTrue(deleted);
    }
}
