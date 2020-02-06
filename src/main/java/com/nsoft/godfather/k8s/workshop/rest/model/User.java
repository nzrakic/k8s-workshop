package com.nsoft.godfather.k8s.workshop.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UserProvider
 */
public class User {

    private int id;
    private String firstname;
    private String lastname;
    private Date registeredAt = new Date();
    @JsonIgnore
    private List<Todo> todos = new ArrayList<>();
    private static int increment = 0;

    public User() {
    }

    public User(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * @return the todos
     */
    public List<Todo> getTodos() {
        return todos;
    }

    public List<Todo> findTodos(Boolean open) {
        if (open == null) {
            return getTodos();
        }

        List<Todo> filtered = new ArrayList<>();

        for (Todo todo : this.todos) {
            if (todo.isOpen() == open) {
                filtered.add(todo);
            }
        }

        return filtered;
    }

    public Todo addTodo(Todo todo) {
        try {
            Todo saved = new Todo();
            saved.setTitle(todo.getTitle()).setBody(todo.getBody()).setId(++increment).open();

            this.todos.add(saved);

            return saved;
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public Todo findSingleTodo(int id) {
        for (Todo todo : this.todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        throw new TodoNotFoundException(id);
    }

    public Todo updateTodo(int id, Todo todo) {
        try {
            return this.findSingleTodo(id).setTitle(todo.getTitle()).setBody(todo.getBody())
                    .setOpen(todo.isOpen());
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public void deleteTodo(int id) {
        Todo todo = this.findSingleTodo(id);
        todos.remove(todo);
    }

    /**
     * @param firstname the firstname to set
     */
    public User setFirstname(String firstname) {
        this.firstname = Objects.requireNonNull(firstname, "First name must be provided");

        return this;
    }

    /**
     * @param lastname the lastname to set
     */
    public User setLastname(String lastname) {
        this.lastname = Objects.requireNonNull(lastname, "Last name must be provided");

        return this;
    }

    /**
     * @param id the id to set
     */
    public User setId(int id) {
        this.id = id;

        return this;
    }

    /**
     * @return the registeredAt
     */
    public Date getRegisteredAt() {
        return registeredAt;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
