package com.switchfully.jeremie.eurder.services.users;

import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import com.switchfully.jeremie.eurder.services.CustomerService;
import com.switchfully.jeremie.eurder.services.UserValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerServiceTest {
    @Test
    void givenNewCustomer_ICanAddItToDatabase() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);
        customerService.registerCustomer(customer);

        Assertions.assertEquals(userDatabase.getUser(customer.getId()), customer);
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfLastNameIsNull() {
        Customer customer = new Customer("John", null, "johndoe@gmail.com", "BeCentral", "1",
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfEmailIsNull() {
        Customer customer = new Customer("John", "Doe", null, "BeCentral", "1",
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfTheStreetNameIsNull() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", null, "1",
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfTheStreetNumberIsNull() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", null,
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfThePostCodeIsNull() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                null, "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfThePostCodeHasNot4Digits() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                "100", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }

    @Test
    void givenNewCustomer_itWillBeRejectedIfTheCityIsNull() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                "1000", null, "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfThePhoneNumberIsNull() {
        Customer customer = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                "1000", "Brussels", null);

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }
    @Test
    void givenNewCustomer_itWillBeRejectedIfEmailIsNotValid() {
        Customer customer = new Customer("John", "Doe", "johndoegmail.com", "BeCentral", "1",
                "1000", "Brussels", "023522536");

        UserDatabase userDatabase = new UserDatabase();
        UserValidationService userValidationService = new UserValidationService();
        CustomerService customerService = new CustomerService(userDatabase, userValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.registerCustomer(customer));
    }





}