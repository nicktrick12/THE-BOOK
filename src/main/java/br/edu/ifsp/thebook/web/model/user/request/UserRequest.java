package br.edu.ifsp.thebook.web.model.user.request;

import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;

import java.sql.Timestamp;
import java.util.UUID;

public class UserRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private Timestamp birth;
    private String CPF;
    private Timestamp entryDate;
    private Role role;

    public UserRequest(String name, String username, String email, String password,
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

    public UserRequest() {
    }

    public User toUser() {
        return User.createFromUser(name, username, email,
                password, birth, CPF, entryDate, role);
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
