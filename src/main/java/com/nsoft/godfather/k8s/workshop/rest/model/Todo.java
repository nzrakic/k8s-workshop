package com.nsoft.godfather.k8s.workshop.rest.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Todo
 */
public class Todo {

    private int id;
    private boolean open;
    private String title;
    private String body = "";
    private Date createdAt = new Date();

    public Todo() {
        this.open = true;
    }

    /**
     * @param body the body to set
     */
    public Todo setBody(String body) {
        this.body = (body == null) ? "" : body;

        return this;
    }

    /**
     * @param title the title to set
     */
    public Todo setTitle(String title) {
        this.title = Objects.requireNonNull(title, "Title must be passed");

        return this;
    }

    /**
     * @param id the id to set
     */
    public Todo setId(int id) {
        this.id = id;

        return this;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the closed
     */
    @JsonIgnore
    public boolean isClosed() {
        return !this.isOpen();
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    @JsonIgnore
    public Todo close() {
        this.open = false;

        return this;
    }

    public Todo open() {
        this.open = true;

        return this;
    }

    /**
     * @param open the open to set
     */
    public Todo setOpen(boolean open) {
        this.open = open;

        return this;
    }
}
