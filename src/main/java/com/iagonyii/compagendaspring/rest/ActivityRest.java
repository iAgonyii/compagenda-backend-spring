package com.iagonyii.compagendaspring.rest;

import com.iagonyii.compagendaspring.domain.Activity;
import com.iagonyii.compagendaspring.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityRest {

    @Autowired
    private ActivityService service;

    @PostMapping
    public String addActivity(@RequestBody Activity activity) {
        service.addActivity(activity);
        return "{}";
    }

    @GetMapping
    public List<Activity> getActivities(@RequestParam("userId") long id) {
        return service.getActivities(id);
    }

    @GetMapping("/teams")
    public List<Activity> getTeamActivities(@RequestParam("teamId") long id) {
        return service.getTeamActivities(id);
    }

    @PostMapping("/{id}")
    public Activity editActivity(@PathVariable long id, Activity activity) {
        return service.editActivity(activity);
    }

    @PostMapping("/delete")
    public void deleteActivity(@RequestBody Activity activity) {
        service.deleteActivity(activity);
    }
}
