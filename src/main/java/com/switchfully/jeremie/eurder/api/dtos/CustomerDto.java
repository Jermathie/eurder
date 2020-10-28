package com.switchfully.jeremie.eurder.api.dtos;


public class CustomerDto {

    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;
    private final String phoneNumber;


    public CustomerDto(String firstName, String lastName, String emailAddress, String streetName, String streetNumber, String postCode, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
