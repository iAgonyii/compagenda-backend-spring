package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Team getTeamOfUser(@RequestParam("userId") long id) {
        return service.getTeamOfUser(id);
    }

    @PostMapping("/delete")
    public void deleteTeam(@RequestBody long id) {
        service.deleteTeam(id);
    }
}
