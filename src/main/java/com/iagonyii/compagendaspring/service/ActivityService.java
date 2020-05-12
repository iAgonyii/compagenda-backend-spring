package com.iagonyii.compagendaspring.service;

import com.iagonyii.compagendaspring.dao.ActivityRepository;
import com.iagonyii.compagendaspring.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public Activity addActivity(Activity activity) {
        return repository.save(activity);
    }

    public List<Activity> getActivities(long id) {
        return repository.getByUserId(id);
    }

    public Activity editActivity(Activity activity) {
        return repository.save(activity);
    }

    public void deleteActivity(Activity activity) {
        repository.delete(activity);
    }
}
