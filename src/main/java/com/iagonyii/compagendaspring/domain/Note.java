package com.iagonyii.compagendaspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue
    private long id;
    private String message;
    private String postedBy;
    private LocalDateTime postedAt;

    public Note(String message, String postedBy, LocalDateTime postedAt) {
        this.message = message;
        this.postedBy = postedBy;
        formatDates(postedAt);
    }

    public Note() {}

    private void formatDates(LocalDateTime postedAt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatPostedAt = postedAt.format(formatter);

        setPostedAt(LocalDateTime.parse(formatPostedAt, formatter));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
