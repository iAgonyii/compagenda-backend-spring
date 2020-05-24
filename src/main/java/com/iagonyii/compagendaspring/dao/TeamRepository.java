package com.iagonyii.compagendaspring.dao;

import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);
    Team findByName(String name);
    Team findByTeamMembers_Id(long userId);
}
