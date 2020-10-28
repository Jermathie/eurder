package com.switchfully.jeremie.eurder.repesitory;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDatabase {
    Map<UUID, User> userDatabase;


    public UserDatabase() {
        this.userDatabase = new HashMap<>();
    }

    public Customer addCustomer(Customer customer){
        userDatabase.put(customer.getId(), customer);
        return (Customer) userDatabase.get(customer.getId());
    }

    public void addAdmin(Admin admin){
        userDatabase.put(admin.getId(), admin);
    }

    public User getUser(UUID id){
        return userDatabase.get(id);
    }

}
