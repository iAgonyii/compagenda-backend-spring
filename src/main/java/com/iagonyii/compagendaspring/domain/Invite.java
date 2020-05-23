package com.iagonyii.compagendaspring.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "invite")
public class Invite {
    @Id
    @GeneratedValue
    private long id;
    private long teamId;
    private long userId;
    private InviteStatusEnum status;

    public Invite(long teamId, long userId) {
        this.teamId = teamId;
        this.userId = userId;
    }

    public Invite() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
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
