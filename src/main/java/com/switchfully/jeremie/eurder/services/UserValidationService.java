package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.exceptions.AdminPrivilegeException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserValidationService {

    public boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        return Pattern.matches(regex, email);
    }

    public void phoneNumberValidation(Customer customer) {
        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().equals("")) {
            throw new IllegalArgumentException("The phone number can't be empty");
        }
    }

    public void emailValidation(Customer customer) {
        if (customer.getEmailAddress() == null || customer.getEmailAddress().equals("")) {
            throw new IllegalArgumentException("Email address can't be empty");
        }
        if (!isValidEmail(customer.getEmailAddress())) {
            throw new IllegalArgumentException("Enter a valid email address");
        }
    }

    public void nameValidation(Customer customer) {
        // Don't create if with first name because some people doesn't have first name
        if (customer.getLastName() == null || customer.getLastName().equals("")) {
            throw new IllegalArgumentException("Last name can't be empty");
        }
    }


    public void validationAddress(Customer customer) {
        if (customer.getStreetName() == null || customer.getStreetName().equals("")) {
            throw new IllegalArgumentException("Street name can't be empty");
        }
        if (customer.getStreetNumber() == null || customer.getStreetNumber().equals("")) {
            throw new IllegalArgumentException("Street number can't be empty");
        }
        if (customer.getPostCode() == null || customer.getPostCode().equals("")) {
            throw new IllegalArgumentException("Post code can't be empty");
        }
        if (customer.getPostCode().length() != 4) {
            throw new IllegalArgumentException("Postal code has 4 digits");
        }
        if (customer.getCity() == null || customer.getCity().equals("")) {
            throw new IllegalArgumentException("Post code can't be empty");
        }
    }

    public boolean isValidUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void getAllCustomerValidation(String checkerId, CustomerService customerService) {
        if (!isValidUUID(checkerId)) {
            throw new IllegalArgumentException("Invalid UUID id");
        }
        UUID adminId = UUID.fromString(checkerId);

        if (!customerService.userDatabase.userExists(adminId)) {
            throw new IllegalArgumentException("this user doesn't exist");
        }

        if (customerService.userDatabase.getUserType(adminId) != Admin.class) {
            throw new AdminPrivilegeException("Only an admin can view all members.");
        }
    }
}
