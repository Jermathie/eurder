package com.switchfully.jeremie.eurder.repesitory;

import com.switchfully.jeremie.eurder.domain.users.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitialDataLoader {
    UserDatabase userDatabase;

    @Autowired
    public InitialDataLoader(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"), "admin", "admin", "admin@admin.com");
        this.userDatabase.addAdmin(admin);
        System.out.println("Admin id: " + admin.getId().toString());
    }
}
