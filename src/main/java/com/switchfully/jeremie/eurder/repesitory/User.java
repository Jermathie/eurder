package com.switchfully.jeremie.eurder.repesitory;

import java.util.UUID;

public abstract class User {
    private UUID id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public User(String firstName, String lastName, String emailAddress) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public User(UUID id, String firstName, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
