package com.switchfully.jeremie.eurder.domain.users;

import com.switchfully.jeremie.eurder.repesitory.User;

import java.util.UUID;

public class Admin extends User {

    public Admin(UUID id, String firstName, String lastName, String emailAddress) {
        super(id, firstName, lastName, emailAddress);
    }
}
