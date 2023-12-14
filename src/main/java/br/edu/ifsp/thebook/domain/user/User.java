package br.edu.ifsp.thebook.domain.user;

import java.util.*;

public class User {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;

    public User(UUID id, String name, String username,
                String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static User createFull(UUID id, String name, String username,
                                  String email, String password) {
        return new User(id, name, username, email, password);
    }

    public static User createFromUser(String name, String username, String email,
                                 String password) {
        return new User(name, username, email, password);
    }

    public User createWithId(UUID id) {
        return new User(id, name, username, email, password);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
