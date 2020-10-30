package com.switchfully.jeremie.eurder.services.users;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.exceptions.AdminPrivilegeException;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import com.switchfully.jeremie.eurder.services.CustomerService;
import com.switchfully.jeremie.eurder.services.UserValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class CustomerServiceTest {

    @Nested
    @DisplayName("add a new customer account")
    public class AddNewCustomerAccount {
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
    @Nested
    @DisplayName("get all customer account")
    public class GetAllCustomerAccount {

        @Test
        void givenListOfCustomers_whenAdminChecks_CustomersAreReturned() {
            UserDatabase userDatabase = new UserDatabase();
            UserValidationService userValidationService = new UserValidationService();
            CustomerService customerService = new CustomerService(userDatabase, userValidationService);
            Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"), "admin", "admin", "admin@admin.com");
            userDatabase.addAdmin(admin);

            Customer customer1 = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            Customer customer2 = new Customer("John", "Smith", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            customerService.registerCustomer(customer2);
            customerService.registerCustomer(customer1);
            List<Customer> customerList = new ArrayList<>();
            customerList.add(customer1);
            customerList.add(customer2);

            Assertions.assertTrue(customerService.getAllCustomers("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9").containsAll(customerList));
        }

        @Test
        void givenListOfCustomers_whenSomeoneOtherThanAdminChecks_ThrowAdminPrivilegeException() {
            UserDatabase userDatabase = new UserDatabase();
            UserValidationService userValidationService = new UserValidationService();
            CustomerService customerService = new CustomerService(userDatabase, userValidationService);
            Customer notAdmin = new Customer(UUID.fromString("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"), "John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            userDatabase.addCustomer(notAdmin);

            Customer customer1 = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            Customer customer2 = new Customer("John", "Smith", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            customerService.registerCustomer(customer2);
            customerService.registerCustomer(customer1);
            List<Customer> customerList = new ArrayList<>();
            customerList.add(customer1);
            customerList.add(customer2);

            Assertions.assertThrows(AdminPrivilegeException.class, () -> customerService.getAllCustomers("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"));
        }

        @Test
        void givenListOfCustomers_whenCheckersIdDoesntExist_ThrowIllegalArgumentException() {
            UserDatabase userDatabase = new UserDatabase();
            UserValidationService userValidationService = new UserValidationService();
            CustomerService customerService = new CustomerService(userDatabase, userValidationService);

            Customer customer1 = new Customer("John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            Customer customer2 = new Customer("John", "Smith", "johndoe@gmail.com", "BeCentral", "1",
                    "1000", "Brussels", "023522536");
            customerService.registerCustomer(customer2);
            customerService.registerCustomer(customer1);
            List<Customer> customerList = new ArrayList<>();
            customerList.add(customer1);
            customerList.add(customer2);

            Assertions.assertThrows(IllegalArgumentException.class, () -> customerService.getAllCustomers("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"));
        }
    }


}