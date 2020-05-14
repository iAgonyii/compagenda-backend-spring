package com.iagonyii.compagendaspring.service;

import com.iagonyii.compagendaspring.dao.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iagonyii.compagendaspring.domain.User;
import com.iagonyii.compagendaspring.domain.Team;

@Service
public class TeamService {

    @Autowired
    private UserService userService;
    @Autowired
    private TeamRepository repository;

    public Team createTeam(String name, long userId) {
        List<User> members = new ArrayList();
        User owner = userService.getUser(userId);

        members.add(owner);
        Team team = new Team(name);
        team.setTeamMembers(members);

        return repository.save(team);
    }

    public void deleteTeam(Team team) {
        repository.delete(team);
    }
}