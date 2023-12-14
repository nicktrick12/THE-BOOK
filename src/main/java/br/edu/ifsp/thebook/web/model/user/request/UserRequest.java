package br.edu.ifsp.thebook.web.model.user.request;

import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.User;

public class UserRequest {
    private String name;
    private String username;
    private String email;
    private String password;

    public UserRequest(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserRequest() {
    }

    public User toUser() {
        return User.createFromUser(name, username, email,
                password);
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