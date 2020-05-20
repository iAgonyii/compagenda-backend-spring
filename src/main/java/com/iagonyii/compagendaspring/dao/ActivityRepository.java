package com.iagonyii.compagendaspring.dao;

import com.iagonyii.compagendaspring.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("from Activity a where a.userId = :uid and a.teamId is null")
    List<Activity> getByUserId (@Param("uid") long userId);

    List<Activity> findAllByTeamId (long teamId);
}
