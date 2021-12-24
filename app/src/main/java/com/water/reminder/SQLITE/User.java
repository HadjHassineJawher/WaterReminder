package com.water.reminder.SQLITE;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String weigth;
    private String heigth;

    public User() {
    }

    public User(String id, String username, String email, String password, String weigth, String heigth) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.weigth = weigth;
        this.heigth = heigth;
    }

    public User(String username, String email, String password, String weigth, String heigth) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.weigth = weigth;
        this.heigth = heigth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", weigth='" + weigth + '\'' +
                ", heigth='" + heigth + '\'' +
                '}';
    }
}
