package br.edu.ifsp.thebook.web.model.user.request;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

<<<<<<< HEAD
    public String geUsername() {
        return username;
    }

    public void setName(String username) {
=======
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
>>>>>>> f4090362c89370636202dac0a4261524a224e09c
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
