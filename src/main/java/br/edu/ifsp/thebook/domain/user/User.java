package br.edu.ifsp.thebook.domain.user;

import java.sql.Timestamp;
import java.util.*;

public class User {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Timestamp birth;
    private String CPF;
    private Timestamp entryDate;
    private Situation situation;
    private Role role;

    public User(UUID id, String name, String username,
                String email, String password, Timestamp birth,
                String CPF, Timestamp entryDate,
                Situation situation, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.CPF = CPF;
        this.entryDate = entryDate;
        this.situation = situation;
        this.role = role;
    }

    public User(String name, String username, String email, String password,
                Timestamp birth, String CPF, Timestamp entryDate, Role role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.CPF = CPF;
        this.entryDate = entryDate;
        this.role = role;
    }

    public User(UUID id, String name, String username,
                String email, String password, Timestamp birth,
                Situation situation, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.situation = situation;
        this.role = role;
    }

    public static User createFull(UUID id, String name, String username,
                                  String email, String password, Timestamp birth,
                                  String CPF, Timestamp entryDate,
                                  Situation situation, Role role) {
        return new User(id, name, username, email, password, birth, CPF, entryDate, situation, role);
    }

    public static User createFromUser(String name, String username, String email,
                                 String password, Timestamp birth, String CPF,
                                 Timestamp entryDate, Role role) {
        return new User(name, username, email, password, birth, CPF, entryDate, role);
    }

    public User createWithId(UUID id) {
        return new User(id, name, username, email, password, birth, CPF, entryDate, situation, role);
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

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
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
