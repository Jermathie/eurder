package com.switchfully.jeremie.eurder.domain.users;

import com.switchfully.jeremie.eurder.repesitory.User;

import java.util.UUID;

public class Customer extends User {

    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String emailAddress, String streetName, String streetNumber, String postCode, String city, String phoneNumber) {
        super(firstName, lastName, emailAddress);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Customer(UUID id, String firstName, String lastName, String emailAddress, String streetName, String streetNumber, String postCode, String city, String phoneNumber) {
        super(id, firstName, lastName, emailAddress);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
