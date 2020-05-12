package com.iagonyii.compagendaspring.dao;

import com.iagonyii.compagendaspring.domain.Activity;
import com.iagonyii.compagendaspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id FROM User u where u.username = :username")
    long getIdForName (@Param("username") String username);

}
