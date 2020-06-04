package com.iagonyii.compagendaspring.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue
    private Long id;
    private String category;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private Long userId;
    @Nullable
    private Long teamId;
    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL)
    private List<Note> notes;

    public Activity(String category, LocalDateTime starttime, LocalDateTime endtime, Long userId) {
        this.category = category;
        formatDates(starttime, endtime);
        this.userId = userId;
    }

    public Activity(String category, LocalDateTime starttime, LocalDateTime endtime, Long userId, @Nullable Long teamId) {
        this.category = category;
        formatDates(starttime, endtime);
        this.userId = userId;
        this.teamId = teamId;
    }

    public Activity() {

    }

    private void formatDates(LocalDateTime starttime, LocalDateTime endtime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatStartTime = starttime.format(formatter);
        String formatEndTime = endtime.format(formatter);

        setStarttime(LocalDateTime.parse(formatStartTime, formatter));
        setEndtime(LocalDateTime.parse(formatEndTime, formatter));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    @Nullable
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(@Nullable Long teamId) {
        this.teamId = teamId;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
