package com.nsoft.godfather.k8s.workshop.rest.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * UserRepository
 */
@Component
public class UserRepository {

    private static List<User> users;
    private static int increment = 0; // id counter

    static {
        // In-memory data set initialization
        users = new ArrayList<>();

        User sofia = new User(++increment, "Sofia", "Loren");
        Todo todo1 = new Todo();
        todo1.setTitle("Buy groceries").setBody("Milk, bread, flower");
        sofia.addTodo(todo1);
        Todo todo2 = new Todo();
        todo2.setTitle("Watch movies").setBody("Jocker, X-men, Ad Astra");
        sofia.addTodo(todo2);
        users.add(sofia);

        User al = new User(++increment, "Al", "Pacino");
        Todo todo3 = new Todo();
        todo3.setTitle("Excercises").setBody("Pushups, situps, squats");
        al.addTodo(todo3);
        users.add(al);

        User steve = new User(++increment, "Steve", "Martin");
        Todo todo4 = new Todo();
        todo4.setTitle("Buy cars").setBody("Stojadin, Trabant");
        steve.addTodo(todo4);
        users.add(steve);
    }

    public User save(User user) {
        try {
            User saved = new User();

            saved.setId(++increment);
            saved.setFirstname(user.getFirstname());
            saved.setLastname(user.getLastname());

            users.add(saved);

            return saved;
        } catch (Exception e) { //some setters will throw an exception, see which ones
            throw new BadRequestException(e.getMessage());
        }
    }

    public User update(int id, User user) {
        try {
            return findOne(id)
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname());
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public void delete(int id) {
        User user = findOne(id);
        users.remove(user);
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new UserNotFoundException(id);
    }

    public List<User> findAll() {
        return users;
    }
}
