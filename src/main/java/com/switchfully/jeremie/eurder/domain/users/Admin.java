package com.switchfully.jeremie.eurder.domain.users;

import java.util.UUID;

public class Admin extends User {

    public Admin(UUID id, String firstName, String lastName, String emailAddress) {
        super(id, firstName, lastName, emailAddress);
    }
}
