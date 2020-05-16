package com.iagonyii.compagendaspring.services;

import com.iagonyii.compagendaspring.domain.Activity;
import com.iagonyii.compagendaspring.service.ActivityService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityServiceTests {
    @Autowired
    ActivityService service;

    @BeforeTestClass
    public static void cleanUsersDB() {
        //DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
        //cleaner.deleteUser("testUser");
    }


    @Test
    @Order(1)
    public void a_AddActivity() {
        Activity activity = new Activity("Testing", LocalDateTime.parse("2020-04-30T12:00:00"), LocalDateTime.parse("2020-04-30T13:00:00"), (long) 69420);
        Activity added = service.addActivity(activity);

        assertEquals(activity, added);
    }

    @Test
    @Order(2)
    public void b_GetActivities() {
        List<Activity> activities = service.getActivities(69420);

        assertEquals("Testing", activities.get(0).getCategory());
    }

    @Test
    @Order(3)
    public void c_EditActivity() {
        List<Activity> activities;
        activities = service.getActivities(69420);
        Activity activity = activities.get(0);
        activity.setCategory("TestingEdit");

        service.editActivity(activity);
        activities = service.getActivities(69420);

        assertEquals("TestingEdit", activities.get(0).getCategory());
    }

    @Test
    @Order(4)
    public void d_DeleteActivity() {
        List<Activity> activities = service.getActivities(69420);
        Activity activity = activities.get(0);
        service.deleteActivity(activity);

        activities = service.getActivities(69420);
        assertEquals(0, activities.size());
    }
}
