package CRS_JEDI_FLIPKART_JAVA_POS.src.com.flipkart.bean;
//package com.flipkart.bean;

/**
 * Author: Group-D
 * Vartika
 * Rohan Mitra
 * Rishabh Verma
 * Shivali Gupta
 * Srujana Sri
 * Asritha Dama
 * Prajwal Rayal
 **/

public class User {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String role;

    /**
     * Constructor
     * @param id The unique identifier for the user
     * @param name The name of the user
     * @param phone The phone number of the user
     * @param email The email address of the user
     * @param password The password for the user's account
     * @param role The role of the user
     */
    public User(int id, String name, String phone, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Gets the user ID
     * @return The user ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user ID
     * @param id The new user ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user name
     * @return The user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user name
     * @param name The new user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user phone number
     * @return The user phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the user phone number
     * @param phone The new user phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the user email address
     * @return The user email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user email address
     * @param email The new user email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user password
     * @return The user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user password
     * @param password The new user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user role
     * @return The user role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the user role
     * @param role The new user role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
