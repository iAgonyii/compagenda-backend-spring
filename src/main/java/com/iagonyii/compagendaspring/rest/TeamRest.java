package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.Invite;
import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamRest {

    @Autowired
    private TeamService service;

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity createTeam(@RequestParam("name") String name, @RequestParam("user") long userId) {
        if(service.createTeam(name, userId)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(path = "/invite", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity teamInviteUser(@RequestParam("teamName") String teamName, @RequestParam("username") String username) {
        if(service.teamInviteUser(teamName, username)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/invite/update")
    public void updateInvite(@RequestBody Invite invite) {
        service.updateInvite(invite);
    }

    @PostMapping(path = "/join", consumes = "application/x-www-form-urlencoded")
    public void joinTeam(@RequestParam("teamName") String teamName, @RequestParam("userId") long userId) {
        service.joinTeam(teamName, userId);
    }

    @PostMapping(path = "/kick", consumes = "application/x-www-form-urlencoded")
    public void kickUserFromTeam(@RequestParam("userId") long userId, @RequestParam("teamId") long teamId) {
        service.kickUserFromTeam(userId, teamId);
    }

    @GetMapping("/invite")
    public List<Invite> getTeamInvites(@RequestParam("userId") long id) { return service.getTeamInvites(id); }

    @GetMapping
    public Team getTeamOfUser(@RequestParam("userId") long id) {
        return service.getTeamOfUser(id);
    }

    @PostMapping("/delete")
    public void deleteTeam(@RequestBody long id) {
        service.deleteTeam(id);
    }
}
