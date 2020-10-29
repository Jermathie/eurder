package com.switchfully.jeremie.eurder.repesitory;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.domain.users.User;
import com.switchfully.jeremie.eurder.exceptions.CustomerNotFoundException;
import com.switchfully.jeremie.eurder.exceptions.NullChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserDatabase {
    Map<UUID, User> userDatabase;

    @Autowired
    public UserDatabase() {
        this.userDatabase = new HashMap<>();
    }

    public Customer addCustomer(Customer customer) {
        userDatabase.put(customer.getId(), customer);
        return (Customer) userDatabase.get(customer.getId());
    }

    public void addAdmin(Admin admin) {
        userDatabase.put(admin.getId(), admin);
    }

    public User getUser(UUID id) {
        return userDatabase.get(id);
    }

    public boolean userExists(UUID id) {
        return userDatabase.containsKey(id);
    }

    public Class<? extends User> getUserType(UUID creatorId) {
        return getUser(creatorId).getClass();
    }

    public List<Customer> getAllCustomers() {
        if (userDatabase.isEmpty()){
            throw new IllegalArgumentException("There are no customers registered");
        }
        return userDatabase.values().stream()
                .filter(user -> user.getClass().equals(Customer.class))
                .map(customer -> (Customer) customer)
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(String customerId) {
        NullChecker.checkArgumentForNull(customerId);
        Customer result = (Customer) userDatabase.get(UUID.fromString(customerId));
        if (result == null) throw new CustomerNotFoundException("The customer with ID: " + customerId + " does not exist!");
        return result;
    }

}
