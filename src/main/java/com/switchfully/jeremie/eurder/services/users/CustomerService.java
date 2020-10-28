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
    public CustomerService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public Customer registerCustomer(Customer customer) {
        validationService.nameValidation(customer);
        validationService.emailValidation(customer);
        validationService.addressValidation(customer);
        validationService.phoneNumberValidation(customer);
        return userDatabase.addCustomer(customer);

    }

}
