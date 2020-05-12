package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamRest {

    @Autowired
    private TeamService service;

    // @TokenNeeded
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public Team createTeam(@RequestParam("name") String name, @RequestParam("user") long userId) {
//        if(service.createTeam(name, userId)) {
//            return Response.status(201).build();
//        }
//        else {
//            return Response.status(409).build();
//        }
        return service.createTeam(name, userId);
    }
}
