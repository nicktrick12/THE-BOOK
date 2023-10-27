package br.edu.ifsp.thebook.domain.user;

import java.util.*;

public class User {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private int age;
    private String cpf;
    private Situation situation;
    private Role role;

    public User(UUID id, String name, String username,
                String email, String password, int age,
                String cpf, Situation situation, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.cpf = cpf;
        this.situation = situation;
        this.role = role;
    }

    public User(UUID id, String name, String username,
                String email, String password, int age,
                Situation situation, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.situation = situation;
        this.role = role;
    }


    public User(String name, String username, String email, String password,
                int age, String cpf, Role role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.cpf = cpf;
        this.role = role;
    }

    public static User createFull(UUID id, String name, String username,
                                  String email, String password, int age,
                                  String cpf, Situation situation, Role role) {
        return new User(id, name, username, email, password, age, cpf, situation, role);
    }

    public static User createFromUser(String name, String username, String email,
                                 String password, int age, String cpf,
                                 Role role) {
        return new User(name, username, email, password, age, cpf, role);
    }

    public User createWithId(UUID id) {
        return new User(id, name, username, email, password, age, cpf, situation, role);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
