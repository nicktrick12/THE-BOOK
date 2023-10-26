package br.edu.ifsp.thebook.web.model.user.response;

import br.edu.ifsp.thebook.ThebookApplication;
import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

public class UserResponse {
    UUID id;
    String name;
    String username;
    String email;
    String password;
    Timestamp birth;
    String CPF;
    Timestamp entryDate;
    Situation situation;
    Role role;

    public UserResponse(UUID id, String name, String username, String email,
                        String password, Timestamp birth, String CPF,
                        Timestamp entryDate, Situation situation, Role role) {
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

    public UserResponse() {
    }

    public static UserResponse createFromUser(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getBirth(),
                user.getCPF(),
                user.getEntryDate(),
                user.getSituation(),
                user.getRole()
        );
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
