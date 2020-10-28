package com.switchfully.jeremie.eurder.services.users;

import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import com.switchfully.jeremie.eurder.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    UserDatabase userDatabase;
    ValidationService validationService;

    @Autowired
    public CustomerService(UserDatabase userDatabase, ValidationService validationService) {
        this.userDatabase = userDatabase;
        this.validationService = validationService;
    }


    public Customer registerCustomer(Customer customer) {
        validationService.validationAddress(customer);
        validationService.nameValidation(customer);
        validationService.emailValidation(customer);
        validationService.phoneNumberValidation(customer);
        return userDatabase.addCustomer(customer);

    }

}
