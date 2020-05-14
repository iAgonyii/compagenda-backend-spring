package com.iagonyii.compagendaspring.dao;

import com.iagonyii.compagendaspring.domain.Team;
import com.iagonyii.compagendaspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    @Query("select count(u.username) from User u where u.username = :username")
    int existsByName (@Param("username") String username);
}
