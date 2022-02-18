package DAO.sql.entity.user;

import DAO.sql.entity.TourOrder;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userID;
    private Type type;

    private String email;
    private String userPassword;

    private String firstName;
    private String lastName;

    private boolean isBlocked;


    public User(Type type, String email, String userPassword,
                String firstName, String lastName, boolean isBlocked) {
        this.type = type;
        this.email = email;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBlocked = isBlocked;
    }

    public User() {

    }

    public User(String email, String userPassword, String firstName, String lastName) {
        this.email = email;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isBlocked=" + isBlocked + '\'' +
                '}';
    }

}
