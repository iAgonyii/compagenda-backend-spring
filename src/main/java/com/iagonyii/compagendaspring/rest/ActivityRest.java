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

    // @TokenNeeded
    @PostMapping
    public String addActivity(@RequestBody Activity activity) {
        service.addActivity(activity);
        return "{}";
    }

    //@TokenNeeded
    @GetMapping
    public List<Activity> getActivities(@RequestParam("userId") long id) {
        return service.getActivities(id);
    }

    //@TokenNeeded
    @PostMapping("/{id}")
    public Activity editActivity(@PathVariable long id, Activity activity) {
        activity.setId(id);
        return service.editActivity(activity);
    }

    // @TokenNeeded
    @DeleteMapping
    public void deleteActivity(Activity activity) {
        service.deleteActivity(activity);
    }
}
