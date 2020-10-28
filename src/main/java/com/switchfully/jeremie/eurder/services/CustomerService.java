package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    UserDatabase userDatabase;
    UserValidationService userValidationService;

    @Autowired
    public CustomerService(UserDatabase userDatabase, UserValidationService userValidationService) {
        this.userDatabase = userDatabase;
        this.userValidationService = userValidationService;
    }

    public List<Customer> getAllCustomers(String checkerId) {
        userValidationService.getAllCustomerValidation(checkerId, this);
        return userDatabase.getAllCustomers();
    }


    public Customer registerCustomer(Customer customer) {
        userValidationService.validationAddress(customer);
        userValidationService.nameValidation(customer);
        userValidationService.emailValidation(customer);
        userValidationService.phoneNumberValidation(customer);
        return userDatabase.addCustomer(customer);

    }

}
