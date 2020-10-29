package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.domain.users.User;
import com.switchfully.jeremie.eurder.exceptions.AdminPrivilegeException;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    UserDatabase userDatabase;
    UserValidationService userValidationService;

    @Autowired
    public CustomerService(UserDatabase userDatabase, UserValidationService userValidationService) {
        this.userDatabase = userDatabase;
        this.userValidationService = userValidationService;
    }

    public Customer registerCustomer(Customer customer) {
        userValidationService.validationAddress(customer);
        userValidationService.nameValidation(customer);
        userValidationService.emailValidation(customer);
        userValidationService.phoneNumberValidation(customer);
        return userDatabase.addCustomer(customer);

    }

    public List<Customer> getAllCustomers(String checkerId) {
        userValidationService.getAllCustomerValidation(checkerId, this);
        return userDatabase.getAllCustomers();
    }

    public User getCustomerById(UUID customerId, UUID userId){
        if (!userValidationService.isValidUUID(customerId.toString())){
            throw new IllegalArgumentException("Invalid Customer ID.");
        }
        if ((userDatabase.userExists(userId)) && (userDatabase.getUserType(userId) != Admin.class)) {
            throw new AdminPrivilegeException("Only admin can see the customer account! You are not an admin.");
        }

        return userDatabase.getUser(customerId);
    }

}
