package com.team4.gymsoftware.db.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Request {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Instant sent;

    @ManyToOne
    @JoinColumn(
            name = "requester_id",
            referencedColumnName = "id"
    )
    private GymUser requester;

    @ManyToOne
    @JoinColumn(
            name = "receiver_id",
            referencedColumnName = "id"
    )
    private Trainer receiver;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Instant getSent() {
        return sent;
    }

    public GymUser getRequester() {
        return requester;
    }

    public Trainer getReceiver() {
        return receiver;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSent(Instant sent) {
        this.sent = sent;
    }

    public void setRequester(GymUser requester) {
        this.requester = requester;
    }

    public void setReceiver(Trainer receiver) {
        this.receiver = receiver;
    }
}
