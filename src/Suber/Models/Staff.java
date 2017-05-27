/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suber.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author sunyifei
 */
public class Staff {
    
    //private SimpleStringProperty username, password,firstName,lastName;
    private SimpleStringProperty firstName,lastName;

    /**public Staff(String username, String password, String firstName, String lastName) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }*/

    public Staff(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    /**public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }*/

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    /**public void setUsername(String value) {
        username.set(value);
    }

    public void setPassword(String value) {
        password.set(value);
    }*/

    public void setFirstName(String value) {
        firstName.set(value);
    }

    public void setLastName(String value) {
        lastName.set(value);
    }

    /**public StringProperty usernameProperty(){
        return username;
    }
    
    public StringProperty passwordProperty(){
        return password;
    }*/
    
    public StringProperty firstNameProperty(){
        return firstName;
    }
    
    public StringProperty lastNameProperty(){
        return lastName;
    }
}
