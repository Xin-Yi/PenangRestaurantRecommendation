package com.example.penangrestaurantrecommendation;

public class User {
    private String email, name, password, userType, id;

    public User(String email, String name, String password, String userType, String id){
        this.email = email;
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.id = id;
    }

    public User(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
