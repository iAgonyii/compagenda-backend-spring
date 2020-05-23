package com.iagonyii.compagendaspring.dao;

import com.iagonyii.compagendaspring.domain.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    List<Invite> findAllByUserId(long userId);
}
