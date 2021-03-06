package com.iagonyii.compagendaspring.service;

import com.iagonyii.compagendaspring.dao.InviteRepository;
import com.iagonyii.compagendaspring.dao.TeamRepository;
import com.iagonyii.compagendaspring.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private UserService userService;
    @Autowired
    private TeamRepository repository;
    @Autowired
    private InviteRepository inviteRepository;

    public boolean createTeam(String name, long userId) {
        if(!repository.existsByName(name)) {

            List<User> members = new ArrayList();
            User owner = userService.getUser(userId);

            members.add(owner);
            Team team = new Team(name);
            team.setTeamMembers(members);
            repository.save(team);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teamInviteUser(String teamName, String username) {
        if(userService.findByName(username) != null) {
            long userId = userService.getIdForName(username);
            Invite invite = new Invite(teamName, userId);
            invite.setStatus(InviteStatusEnum.Pending);
            inviteRepository.save(invite);
            return true;
        }
        else {
            return false;
        }
    }

    public void updateInvite(Invite invite) {
        inviteRepository.save(invite);
    }

    public void joinTeam(String teamName, long userId) {
        Team team = repository.findByName(teamName);
        User user = userService.getUser(userId);
        List<User> members = team.getTeamMembers();
        members.add(user);
        team.setTeamMembers(members);
        repository.save(team);
    }

    public void kickUserFromTeam(long userId, long teamId) {
        Team team = repository.findById(teamId).get();
        User user = userService.getUser(userId);
        List<User> members = team.getTeamMembers();
        members.remove(user);
        team.setTeamMembers(members);
        repository.save(team);
    }

    public List<Invite> getTeamInvites(long userId) {
        return inviteRepository.findAllByUserId(userId);
    }

    public void deleteTeam(long id) {
        repository.deleteById(id);
    }

    public Team getTeamOfUser(long id) { return repository.findByTeamMembers_Id(id); }

    public List<Team> getTeams() {
        return repository.findAll();
    }
}
