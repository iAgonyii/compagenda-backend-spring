package com.iagonyii.compagendaspring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "invite")
public class Invite {
    @Id
    @GeneratedValue
    private long id;
    private String teamName;
    private long userId;
    private InviteStatusEnum status;


    public Invite(String teamName, long userId) {
        this.teamName = teamName;
        this.userId = userId;
    }

    public Invite() {

    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public InviteStatusEnum getStatus() {
        return status;
    }

    public void setStatus(InviteStatusEnum status) {
        this.status = status;
    }
}
